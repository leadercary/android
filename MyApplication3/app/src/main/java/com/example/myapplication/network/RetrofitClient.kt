package com.example.myapplication.network

import com.example.myapplication.network.service.LoginService
import com.example.myapplication.network.service.PostService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val gson : Gson = GsonBuilder()
        .setLenient()
        .create()
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.80.161.211:8080/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    val postService: PostService = retrofit.create(PostService::class.java)
    val loginService: LoginService = retrofit.create(LoginService::class.java)

}