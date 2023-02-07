package com.example.myapplication.network

import com.example.myapplication.network.service.LoginRetrofitService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val gson : Gson = GsonBuilder()
        .setLenient()
        .create()
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.80.162.226:8080/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val loginService: LoginRetrofitService = retrofit.create(LoginRetrofitService::class.java)

}