package com.example.retotecnicomm.presentation


//import androidx.compose.runtime.*
import HomeViewModelFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
//import com.example.retotecnicomm.components.CardImage
//import com.example.retotecnicomm.ui.utils.FileUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@Composable
fun HomeScreen(navController: NavController) {

// Obtener el contexto actual
    val context = LocalContext.current
//Iniciar el viewModel
    val viewModel: HomeViewModel = viewModel(factory = HomeViewModelFactory(context))
//get img from galery
    val imageUri = rememberSaveable { mutableStateOf<Uri?>(null) }

    val laucher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            val fileName = "image.jpg"
            runBlocking {
                withContext(Dispatchers.IO) {
                    FileUtils.saveImageToInternalStorage(context, it, fileName)
                    val imagePath = context.filesDir.path + "/images/$fileName"
                    viewModel.addImage(imagePath)
                }
            }
        }
    }

    LaunchedEffect(viewModel) {
        viewModel.loadImages()
    }

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        val imageList = viewModel.getImageList()
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Text(
                    text = "Galería de Imágenes",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )
                Button(
                    onClick = { laucher.launch("image/*") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(text = ".+")
                }
            }

            items(imageList) { imagePath ->
                CardImage(imagePath = imagePath, viewModel = viewModel)
            }
        }

    }
}
//
//        imageList.forEach { imagePath ->
//            CardImage(imagePath = imagePath, viewModel = viewModel)
//        }


