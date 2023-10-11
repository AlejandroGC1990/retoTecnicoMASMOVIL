package com.example.retotecnicomm.ui.utils

import android.content.Context
import android.net.Uri
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

sealed class Screen(val key: String) {
    object Login : Screen("login")
    object Home : Screen("home")
}


object FileUtils {
    fun saveImageToInternalStorage(context: Context, imageUri: Uri, fileName: String) {
        try {
            val inputStream: InputStream? = context.contentResolver.openInputStream(imageUri)
            if (inputStream != null) {
                val directory = File(context.filesDir, "images")
                if (!directory.exists()) {
                    directory.mkdirs()
                }
                val file = File(directory, fileName)
                var count = 1
                while (file.exists()){
                    val fileName = "$fileName ($count)"
                    val file = File(directory, fileName)
                    count++
                }
                val outputStream = FileOutputStream(file)
                val buffer = ByteArray(1024)
                var read: Int
                while (inputStream.read(buffer).also { read = it } != -1) {
                    outputStream.write(buffer, 0, read)
                }
                outputStream.flush()
                outputStream.close()
                inputStream.close()

                Log.d("ImagePaths", "Image saved to: ${file.absolutePath}")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}