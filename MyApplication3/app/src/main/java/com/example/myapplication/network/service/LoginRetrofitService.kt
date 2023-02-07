package com.example.myapplication.network.service

import com.example.myapplication.network.model.LoginData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitService {
    @POST("/api/user/signin")
    fun signIn(@Body login:LoginData) : Call<String>
}