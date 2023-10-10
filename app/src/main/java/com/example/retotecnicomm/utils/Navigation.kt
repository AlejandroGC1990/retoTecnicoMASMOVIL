package com.example.retotecnicomm.utils

sealed class Screen(val key: String) {
    object Login : Screen("login")
    object Home : Screen("home")
}
