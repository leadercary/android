package com.example.myapplication.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.RetrofitClient
import com.example.myapplication.network.model.LoginData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel : ViewModel() {

    lateinit var id: MutableLiveData<String>
    lateinit var password: MutableLiveData<String>



    fun login(){
        RetrofitClient.loginService.signIn(LoginData(id.toString(),password.toString(),null)).enqueue(object : retrofit2.Callback<String> {
            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                if (response.isSuccessful) {
                    var result = response.body()
                    Log.d("1","로그인성공 ${result}")
                }
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("euya","로그인실패")
            }
        })
    }
}


