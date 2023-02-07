package com.example.myapplication.network.service

import com.example.myapplication.network.model.LoginData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginService {
    @POST("/api/user/signin")
    fun signIn(
        @Header("Authorization") token: String?,
        @Body login:LoginData) : Call<String>
}