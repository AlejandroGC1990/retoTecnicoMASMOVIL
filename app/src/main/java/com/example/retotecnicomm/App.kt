package com.example.retotecnicomm

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.retotecnicomm.screens.home.HomeScreen
import com.example.retotecnicomm.screens.login.LoginScreen
import com.example.retotecnicomm.ui.utils.Screen

@Composable
fun App() {
    val navController = rememberNavController()
    val context = LocalContext.current

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
            HomeScreen(context)
        }
    }
}
