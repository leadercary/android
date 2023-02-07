package com.example.myapplication.network

import com.example.myapplication.network.service.LoginRetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.80.162.226:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val loginService: LoginRetrofitService = retrofit.create(LoginRetrofitService::class.java)

}