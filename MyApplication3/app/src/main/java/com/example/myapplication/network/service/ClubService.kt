package com.example.myapplication.network.service

import com.example.myapplication.network.model.Club
import com.example.myapplication.network.model.ClubDto
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface ClubService {
    @POST("/api/post/getname")
    fun getName(
        @Query("name") name: String
    ): Call<ClubDto>
}