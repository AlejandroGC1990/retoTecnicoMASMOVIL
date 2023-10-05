package com.example.retotecnicomm

sealed class Screen(val key: String) {
    object Login : Screen("login")
    object Home : Screen("home")
}
