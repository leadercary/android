package com.example.myapplication.network.service

import com.example.myapplication.network.model.Post
import com.example.myapplication.network.model.text
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface PostService {
    @POST("/api/post/search")
    fun search(
        @Query ("text")text: String
    ): Call<List<Post>>
}