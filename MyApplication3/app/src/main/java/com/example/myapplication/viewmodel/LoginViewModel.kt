package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.RetrofitClient
import com.example.myapplication.network.model.LoginDto
import com.example.myapplication.view.fragment.AdminMainFragment
import com.example.myapplication.view.fragment.LoginFragment
import retrofit2.Call
import retrofit2.Response


class LoginViewModel : ViewModel() {

    val changer = MutableLiveData<Boolean>()
    val result = MutableLiveData<String>()


    fun login(id:Any, pw:Any){
        Log.d("euya", id.toString())
        Log.d("euya", pw.toString())
        RetrofitClient.loginService.signIn(result.value,LoginDto(id.toString(),pw.toString(),null)).enqueue(object : retrofit2.Callback<String> {
            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                if (response.isSuccessful) {
                    result.value = response.body()
                    Log.d("euya","로그인성공 ${result.value}")
                    changer.value = true
                    LoginFragment().saveToken(result.value)
                }
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("euya","${t.message}")
            }
        })
    }
}


