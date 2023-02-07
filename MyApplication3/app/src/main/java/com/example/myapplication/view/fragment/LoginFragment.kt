package com.example.myapplication.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.view.activity.MainActivity
import com.example.myapplication.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel = LoginViewModel()
        binding.backbtn.setOnClickListener {
            (activity as MainActivity).switchFragment(MainFragment())
        }
        binding.loginBtn.setOnClickListener {
            val id = binding.idLoginEdit.text
            val pw = binding.passwordLoginEdit.text
            loginViewModel.login(id, pw)
        }
        loginViewModel.changer.observe(viewLifecycleOwner, Observer {
            if (loginViewModel.changer.value == true){
                (activity as MainActivity).switchFragment(AdminMainFragment())
                loginViewModel.changer.value = false
            }
        })
    }
}