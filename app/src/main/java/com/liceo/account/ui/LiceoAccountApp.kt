package com.liceo.account.ui

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LiceoAccountApp(vm: AuthViewModel = viewModel()) {
    var screen by rememberSaveable { mutableStateOf("login") }
    val state = vm.uiState
    if (state is AuthUiState.LoggedIn) {
        ProfileScreen(state.user) { vm.logout(); screen = "login" }
    } else if (screen == "register") {
        RegisterScreen(state, vm::register) { vm.clearMessage(); screen = "login" }
    } else {
        LoginScreen(state, vm::login) { vm.clearMessage(); screen = "register" }
    }
}
