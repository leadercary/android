package com.example.myapplication.network.service

import com.example.myapplication.network.model.Post
import com.example.myapplication.network.model.SearchText
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PostService {
    @POST("/api/post/search")
    fun search(
        @Body text: SearchText
    ): Call<List<Post>>
}