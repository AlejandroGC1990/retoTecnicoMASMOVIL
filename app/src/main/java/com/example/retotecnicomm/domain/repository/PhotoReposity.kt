package com.example.retotecnicomm.domain.repository

import com.example.retotecnicomm.domain.model.Photo
import kotlinx.coroutines.flow.Flow

/* Aquí se crea el tipo de dato photo, que será un listado de objetos de tipo photo" */
typealias Photos = List<Photo>

//Definir las funciones que usará viewModel para acceder a los datos
interface PhotoReposity {
    fun getImagesFromRoom(): Flow<Photos>
    fun addImageToRoom(image: Photo)
    //getImageFromRoom
    //updateImageInRoom
    //deleteImageFromRoom

}