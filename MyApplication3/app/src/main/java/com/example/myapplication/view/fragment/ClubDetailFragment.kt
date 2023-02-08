package com.example.myapplication.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myapplication.viewmodel.ClubDetailViewModel
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentClubDetailBinding
import com.example.myapplication.databinding.FragmentMainBinding

class ClubDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ClubDetailFragment()
    }
    lateinit var binding: FragmentClubDetailBinding
    private lateinit var clubDetailViewModel: ClubDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_club_detail,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val club = arguments?.getString("club")
        binding.clubName.text=club
        clubDetailViewModel=ClubDetailViewModel()
    }
}