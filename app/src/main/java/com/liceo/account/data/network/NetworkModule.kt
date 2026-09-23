package com.liceo.account.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object NetworkModule {
    private const val BASE_URL = "https://6a9b85920ad174e139e8b0f2.mockapi.io/chat-messaging/api/v1/"

    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder().addInterceptor(logging).build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val userApi: UserApiService = retrofit.create(UserApiService::class.java)
}
