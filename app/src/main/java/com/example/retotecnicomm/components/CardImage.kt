package com.example.retotecnicomm.components

//import androidx.compose.runtime.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.retotecnicomm.viewmodel.HomeViewModel
import java.io.File

@Composable
fun CardImage (imagePath: String, viewModel: HomeViewModel) {
//    val viewModel: HomeViewModel = viewModel

    val file = File(imagePath)
    val imageName = file.name

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
//        Text(
//            text = title,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            textAlign = TextAlign.Center,
//        )
        Image(
//            painter = painterResource(id = imageResId),
            painter = rememberAsyncImagePainter(
                model = File(imagePath)
                //builder = {configuracion adicional de la iamgen}
            ),
            contentDescription = null,
            modifier = Modifier.width(120.dp).height(200.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = imageName, // Mostrar el nombre del archivo
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.weight(1f).padding(8.dp)
            )
            Button(
                onClick = {
                    viewModel.removeImage(imagePath)
                },
                colors = ButtonDefaults.buttonColors(),
                modifier = Modifier.padding(8.dp)
                )
            {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar imagen"
                    )
                }
            }
    }
}