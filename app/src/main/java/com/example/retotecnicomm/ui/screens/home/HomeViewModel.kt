package com.example.retotecnicomm.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.retotecnicomm.R

class HomeViewModel : ViewModel() {
//    private val apiService: ImgurApiService
//
//    init{
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.imgur.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        apiService = retrofit.create(ImgurApiService::class.java)
//    }
//
//    //this fun will call to get img from service
//    suspend fun fetchGalleryImages(page: Int): List<ImgurApiService.ImgurImage> {
//        return withContext(Dispatchers.IO) {
//            try{
//                val response = apiService.getImages(page = page, perPage = 100)
//                if(response.success){
//                    response.data
//                } else {
//                    emptyList()
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//                emptyList()
//            }
//        }
//    }
    private val imageList = mutableListOf<Int>()

    init {
        imageList.add(R.drawable.image1)
        imageList.add(R.drawable.image2)
    }

    fun getImageList(): List<Int> {
        return imageList
    }

    fun removeImage(imageResId: Int) {
        imageList.remove(imageResId)
    }
//
//    fun loadImageAsync() {
//        viewModelScope.launch(Dispatcher.IO) {
//            imageList.addAll(repository.loadImages())
//        }
//    }
}