package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.RetrofitClient
import com.example.myapplication.network.model.Post
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response

class AddViewModel : ViewModel() {
    val body = MutableLiveData<MultipartBody.Part>()
    fun imagePost() {
        if(body.value != null){
            RetrofitClient.postService.postImage(body.value!!)
                .enqueue(object : retrofit2.Callback<String> {
                    override fun onResponse(
                        call: Call<String>,
                        response: Response<String>
                    ) {
                        Log.d("suc", response.toString())
                        if (response.isSuccessful) {

                        }
                    }

                    override fun onFailure(call: Call<String>, t: Throwable) {
                        Log.d("error", "$t")
                    }

                })
        }

    }
}