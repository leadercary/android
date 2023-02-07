package com.example.myapplication.view.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.view.fragment.ClubDetailFragment
import com.example.myapplication.view.fragment.MainFragment

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment()
    }

    private fun setFragment(){
        //첫 프래그먼트는 무조건 ADD가 한개 이상 필요함
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frame_fragment, MainFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun switchFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun onBackPressed() {
        for (fragment in supportFragmentManager.fragments) {
            if (fragment.isVisible) {
                if (fragment is MainFragment) {
                    finishAffinity()
                } else if(fragment is ClubDetailFragment){
                    switchFragment(MainFragment())
                }
            }
        }
    }

}