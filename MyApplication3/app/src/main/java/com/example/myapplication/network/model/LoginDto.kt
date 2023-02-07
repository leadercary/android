package com.example.myapplication.network.model

data class LoginDto(
    val identity : String,
    val password : String?,
    val remember : String?

//    "identity": "string",
//"idx": 0,
//"password": "string",
//"remember": "string",
//"remember_time": "2023-02-07"
)
