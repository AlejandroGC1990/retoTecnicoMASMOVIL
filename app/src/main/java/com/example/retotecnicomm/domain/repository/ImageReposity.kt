package com.example.retotecnicomm.domain.repository

import android.provider.MediaStore
import com.example.retotecnicomm.domain.model.Image
import kotlinx.coroutines.flow.Flow

/* Aquí se crea el tipo de dato image" */
typealias Image = List<Image>

//Funciones que usará viewModel para acceder a los datos
interface ImageReposity {
    fun getImagesFromRoom(): Flow<MediaStore.Images>
    fun addImageToRoom(image: Image)
    //getImageFromRoom
    //updateImageInRoom
    //deleteImageFromRoom

}