package com.example.retotecnicomm.api//package com.example.retotecnicomm.api
//
//import retrofit2.http.GET
//import retrofit2.http.Query
//
//interface ImgurApiService {
//    @GET("3/gallery/hot/viral/0.json")
//    suspend fun getImages(
//        @Query("page") page: Int,
//        @Query("per_page") perPage: Int
//    ): ImgurResponse
//
//    annotation class GET(val value: String)
//
//    data class ImgurResponse(
//        val data: List<ImgurImage>,
//        val success: Boolean,
//        val status: Int
//    )
//
//    data class ImgurImage(
//        val id: String,
//        val title: String,
//        val description: String?,
//        val link: String
//    )
//}