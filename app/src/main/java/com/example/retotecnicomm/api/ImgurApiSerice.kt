package com.example.retotecnicomm.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ImgurApiService {
    @GET("3/gallery/user/rising/0.json")
    suspend fun getImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): ImgurApiServiceFactory


    object ImgurApiServiceFactory {
        fun makeImgurApiService():ImgurApiService{
            return Retrofit.Builder()
                .baseUrl("https://api.imgur.com/" /*.BASE_URL*/)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(ImgurApiService::class.java)
        }
    }
}
