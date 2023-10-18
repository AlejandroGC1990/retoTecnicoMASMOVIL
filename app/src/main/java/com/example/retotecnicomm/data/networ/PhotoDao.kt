package com.example.retotecnicomm.data.networ

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.retotecnicomm.core.Constants.PHOTO_TABLE
import com.example.retotecnicomm.domain.model.Photo
import com.example.retotecnicomm.domain.repository.Photos
import kotlinx.coroutines.flow.Flow


//Capa de acceso a datos
@Dao
interface PhotoDao {
    /*Esta interfaz realiza el acceso a datos y tiene una función que hace de SELECT
    * y otra que hace de INSERT*/

    @Query("SELECT * FROM $PHOTO_TABLE ORDER BY id ASC")
    fun getPhotos(): Flow<Photos>

    @Insert(onConflict = IGNORE)
    fun addPhoto(photo: Photo)

    //getPhoto
    //updatePhoto
    //deletePhoto
}