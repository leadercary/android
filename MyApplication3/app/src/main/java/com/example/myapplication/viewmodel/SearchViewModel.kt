package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.R
import com.example.myapplication.network.RetrofitClient
import com.example.myapplication.network.model.Club
import com.example.myapplication.network.model.Post
import com.example.myapplication.network.model.text
import retrofit2.Call
import retrofit2.Response

class SearchViewModel : ViewModel() {
    val keyword = MutableLiveData<String>()
    val itemList = MutableLiveData<List<Post>>()
    fun searchPost() {
        Log.d("TAG", keyword.value.toString())
        RetrofitClient.postService.search(keyword.value.toString())
            .enqueue(object : retrofit2.Callback<List<Post>> {
            override fun onResponse(
                call: Call<List<Post>>,
                response: Response<List<Post>>
            ) {
                if (response.isSuccessful) {
                    val imageList = mutableListOf<Int>()
                    for(i in response.body()!!.indices) {

                    }
                    itemList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }

        })
    }
    fun getImage(indices: List<Int>) {

    }
}