package com.liceo.account.data

import com.liceo.account.core.AppResult
import com.liceo.account.data.network.NetworkModule
import com.liceo.account.data.network.UserApiService
import com.liceo.account.data.network.dto.NewUserDto
import com.liceo.account.data.network.dto.UserDto
import com.liceo.account.data.network.dto.toDomain
import com.liceo.account.domain.model.User
import kotlinx.serialization.SerializationException
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class UserRepository(private val api: UserApiService = NetworkModule.userApi) {
    private suspend fun findUsers(email: String): List<UserDto> = try {
        api.findByEmail(email)
    } catch (e: HttpException) {
        if (e.code() == 404) emptyList() else throw e
    }

    private suspend fun <T> safeCall(block: suspend () -> AppResult<T>): AppResult<T> = try {
        block()
    } catch (_: UnknownHostException) {
        AppResult.Failure.NoInternet
    } catch (_: SocketTimeoutException) {
        AppResult.Failure.Timeout
    } catch (e: IOException) {
        if (e is SerializationException) AppResult.Failure.Unknown(e.message) else AppResult.Failure.NoInternet
    } catch (e: HttpException) {
        AppResult.Failure.Unknown("HTTP ${e.code()}")
    } catch (e: Exception) {
        AppResult.Failure.Unknown(e.message)
    }

    suspend fun login(email: String, password: String): AppResult<User> = safeCall {
        val matches = findUsers(email.trim())
        val found = matches.firstOrNull {
            it.email?.trim()?.equals(email.trim(), ignoreCase = true) == true && it.password == password
        }
        if (found == null) AppResult.Failure.WrongLogin else AppResult.Success(found.toDomain())
    }

    suspend fun register(fullName: String, email: String, password: String, birthdate: String): AppResult<User> = safeCall {
        val trimmedEmail = email.trim()
        val taken = findUsers(trimmedEmail).any {
            it.email?.trim()?.equals(trimmedEmail, ignoreCase = true) == true
        }
        if (taken) {
            AppResult.Failure.EmailTaken
        } else {
            val saved = api.createUser(NewUserDto(fullName.trim(), trimmedEmail, password, birthdate.trim()))
            AppResult.Success(saved.toDomain())
        }
    }
}
