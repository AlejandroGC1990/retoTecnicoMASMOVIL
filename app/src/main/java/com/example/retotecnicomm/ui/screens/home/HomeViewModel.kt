package com.example.retotecnicomm.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.retotecnicomm.api.ImgurApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel : ViewModel() {
    private val apiService: ImgurApiService

    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.imgur.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ImgurApiService::class.java)
    }

    //this fun will call to get img from service
    suspend fun fetchGalleryImages(page: Int): List<ImgurApiService.ImgurImage> {
        return withContext(Dispatchers.IO) {
            try{
                val response = apiService.getImages(page = page, perPage = 100)
                if(response.success){
                    response.data
                } else {
                    emptyList()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                emptyList()
            }
        }
    }
}