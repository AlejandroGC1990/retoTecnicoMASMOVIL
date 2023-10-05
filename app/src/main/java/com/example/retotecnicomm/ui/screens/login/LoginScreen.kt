package com.example.retotecnicomm.ui.screens.login

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LoginScreen(goToHome: () -> Unit) {
    Row {
        Text(text = "Login")
        Button(onClick = goToHome) {}
    }
}