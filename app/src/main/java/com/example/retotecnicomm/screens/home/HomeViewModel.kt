package com.example.retotecnicomm.screens.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import java.io.File

class HomeViewModel(private val context: Context) : ViewModel() {

    // Lista para almacenar las rutas de las imágenes en la memoria interna
    private val imageList = mutableListOf<String>()

    init {
        loadImages()
    }

    fun loadImages() {
        val directory = File(context.filesDir, "images")
        if (directory.exists() && directory.isDirectory) {
            val files = directory.listFiles()
            files?.forEach { file ->
                imageList.add(file.absolutePath)
                Log.d("ImagePaths", "Added image path: ${file.absolutePath}")
            }
        }
    }

    fun getImageList(): List<String> {
        return imageList
    }

    // Agregar una nueva ruta de imagen a la lista
    fun addImage(imagePath: String) {
        imageList.add(imagePath)
        loadImages()
    }

    //Delete img from res.drawable
    fun removeImage(imagePath: String) {
        if (imageList.contains(imagePath)) {
            imageList.remove(imagePath)
            val file = File(imagePath)
            if (file.exists()) {
                file.delete()
            }
        }
        loadImages()
    }
}