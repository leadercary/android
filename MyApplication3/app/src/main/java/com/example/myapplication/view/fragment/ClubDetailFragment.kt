package com.example.myapplication.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.viewmodel.ClubDetailViewModel
import com.example.myapplication.R

class ClubDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ClubDetailFragment()
    }

    private lateinit var viewModel: ClubDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_club_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val club = arguments?.getString("club")
    }
}