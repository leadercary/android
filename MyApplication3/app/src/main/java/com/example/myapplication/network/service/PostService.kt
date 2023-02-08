package com.example.myapplication.network.service

import com.example.myapplication.network.model.Post
import com.example.myapplication.network.model.text
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface PostService {
    @POST("/api/post/search")
    fun search(
        @Query ("text")text: String
    ): Call<List<Post>>

    @Multipart
    @POST("/api/image/upload")
    fun postImage(
        @Part image: MultipartBody.Part
    ) : Call<String>
}