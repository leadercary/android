package com.example.myapplication.network.model

import java.util.Date

data class Post(
    val club_idx : Int,
    val create_time	: String,
    val detail : String,
    val idx	: Int,
    val name : String,
    val title : String,
    val view : Int
)
