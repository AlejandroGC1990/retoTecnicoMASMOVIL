//package com.example.retotecnicomm.api
//
//import com.google.gson.GsonBuilder
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object RetrofitClient {
//    val webService: ImgurApiService by lazy {
//        Retrofit.Builder()
//            .baseUrl("https://api.imgur.com/" /*.BASE_URL*/)
//            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//            .build()
//            .create(ImgurApiService::class.java)
//    }
//}