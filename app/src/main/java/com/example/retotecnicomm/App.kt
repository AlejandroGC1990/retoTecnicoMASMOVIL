package com.example.retotecnicomm

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.retotecnicomm.ui.screens.home.HomeScreen
import com.example.retotecnicomm.ui.screens.login.LoginScreen
import com.example.retotecnicomm.utils.Screen

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.key
    ) {
        composable(Screen.Login.key) {
            LoginScreen(goToHome = {
                navController.navigate(Screen.Home.key)
            })
        }
        composable("home") {
            HomeScreen()
        }
    }
}
