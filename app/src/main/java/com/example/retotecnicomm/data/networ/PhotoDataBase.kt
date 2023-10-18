package com.example.retotecnicomm.data.networ

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.retotecnicomm.domain.model.Photo

/*Esta clase hereda de roomDataBase, por lo que crea una base de datos de room con la entidad que
* definí en la clase Photo*/

@Database(entities = [Photo::class], version = 1, exportSchema = false) //<--Le indicamos que no exporte el esquema de base de datos a una carpeta
abstract class PhotoDataBase: RoomDatabase() {

    //La siguiente clase implementará la interface PhotoRepository
    abstract fun mascotaDao(): PhotoDao
}