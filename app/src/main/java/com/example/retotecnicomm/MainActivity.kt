package com.example.retotecnicomm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.retotecnicomm.theme.RetoTecnicoMmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetoTecnicoMmTheme {
                App()
            }
        }
    }
}
