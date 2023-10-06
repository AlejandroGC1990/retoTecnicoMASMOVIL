package com.example.retotecnicomm.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.retotecnicomm.R
import com.example.retotecnicomm.api.ImgurApiService

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navigateToCamera: () -> Unit
) {
    Text(text = "Home PATATATATATATATATATATATATATATATATATATATATATAT")

    val images = remember { mutableStateListOf<ImgurApiService.ImgurImage>() }

    LaunchedEffect(Unit) {
        images.addAll(viewModel.fetchGalleryImages(page = 0))
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Gallery") },
                backgroundColor = Color.DarkGray
                )
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.DarkGray
            ) {
                IconButton(
                    onClick = {navigateToCamera()},
                    modifier = Modifier.padding(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_camera_alt_24),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(images) { image ->
                Card(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.placeholder),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                }

            }
        }
    }

}


