package com.example.retotecnicomm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.retotecnicomm.presentation.HomeScreen
import com.example.retotecnicomm.presentation.LoginScreen
import com.example.retotecnicomm.presentation.LoginScreenViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.LoginScreen.name
    ) {
        composable(Screens.LoginScreen.name) {
            LoginScreen(
                viewModel = LoginScreenViewModel(),
                onLoginComplete = { success ->
                    if (success) {
                        navController.navigate(Screens.HomeScreen.name)
                    }
                }
            )
        }
        composable(Screens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
    }
}