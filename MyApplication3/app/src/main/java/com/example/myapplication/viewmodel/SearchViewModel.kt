package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.RetrofitClient
import com.example.myapplication.network.model.Post
import retrofit2.Call
import retrofit2.Response

class SearchViewModel : ViewModel() {
    val keyWord = MutableLiveData<String>()
    val itemList = MutableLiveData<List<Post>>()
    fun searchPost() {
        val call = RetrofitClient.postService.searchPost(keyWord.value!!)

        call.enqueue(object : retrofit2.Callback<List<Post>> {
            override fun onResponse(
                call: Call<List<Post>>,
                response: Response<List<Post>>
            ) {
                if (response.isSuccessful) {
                    itemList.value = response.body()?.data ?: emptyList()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }

        })
    }
}