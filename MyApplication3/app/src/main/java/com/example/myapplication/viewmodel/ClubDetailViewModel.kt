package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.RetrofitClient
import com.example.myapplication.network.model.ClubDto
import com.example.myapplication.network.model.Post
import retrofit2.Call
import retrofit2.Response

class ClubDetailViewModel : ViewModel() {
    val clubName = MutableLiveData<String>()
    fun findClub() {
        RetrofitClient.clubService.getName(clubName.value.toString())
            .enqueue(object : retrofit2.Callback<ClubDto> {
                override fun onResponse(
                    call: Call<ClubDto>,
                    response: Response<ClubDto>
                ) {
                    if (response.isSuccessful) {

                    }
                }

                override fun onFailure(call: Call<ClubDto>, t: Throwable) {
                }

            })
    }
}