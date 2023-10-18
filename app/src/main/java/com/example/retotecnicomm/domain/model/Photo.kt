package com.example.retotecnicomm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.retotecnicomm.core.Constants.PHOTO_TABLE

/*Aquí se crea la clase que contiene los datos de la imagen
    (la entidad principal a almacenar") */

@Entity(tableName = PHOTO_TABLE) //"Entity se usa para hacer una tabla de datos"
data class Photo(

    @PrimaryKey(autoGenerate = true) //PrimaryKey es para disponer de un camnpo autoadministrado
    val id: Int,
    val url: String,
    val description: String
)