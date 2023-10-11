package com.example.retotecnicomm

import HomeViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.retotecnicomm.screens.home.HomeViewModel
import com.example.retotecnicomm.theme.RetoTecnicoMmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModelFactory = HomeViewModelFactory(this)
            val viewModel: HomeViewModel = viewModel(factory = viewModelFactory)

            RetoTecnicoMmTheme {
                App()
            }
        }
    }
}
