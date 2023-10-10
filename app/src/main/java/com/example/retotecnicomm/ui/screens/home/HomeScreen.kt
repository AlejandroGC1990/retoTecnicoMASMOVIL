package com.example.retotecnicomm.ui.screens.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.retotecnicomm.ui.components.CardImage
@Composable
fun HomeScreen() {

    val viewModel: HomeViewModel = viewModel()

    val imageList = remember {viewModel.getImageList()}

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Text(
                text = "Home PATATATATATATATATATATATATATATATATATATATATATAT",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "Home Galería de Imágenes",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )

            imageList.forEach { imageResource ->
                CardImage(imageResId = imageResource, viewModel = viewModel)
            }
        }
    }

}


