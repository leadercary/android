package com.example.myapplication.network.model


import com.google.gson.annotations.SerializedName

data class postX(
    @SerializedName("club_idx")
    val clubIdx: Int,
    @SerializedName("create_time")
    val createTime: List<Int>,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("idx")
    val idx: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("view")
    val view: Int
)