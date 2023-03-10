package com.example.myapplication.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.FragmentMainBinding
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.viewmodel.MainViewModel
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.network.model.App.Companion.prefs
import com.example.myapplication.network.model.Club
import com.example.myapplication.view.activity.MainActivity
import com.example.myapplication.view.adapter.ClubAdapter

class MainFragment() : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var mainViewModel: MainViewModel

lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = MainViewModel()
        binding.adminBtn.setOnClickListener{
            if (prefs.token.isNullOrEmpty()){
                (activity as MainActivity).switchFragment(LoginFragment(), null)
            } else {
                (activity as MainActivity).switchFragment(AdminMainFragment(), null)
            }
        }
        binding.bgSearch.setOnClickListener {
            (activity as MainActivity).switchFragment(SearchFragment(), null)
        }
        initRecycler()
        initFreeRecycler()
        mainViewModel.onclick.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).switchFragment(ClubDetailFragment(), mainViewModel.onclick.value)
            mainViewModel.onclick.postValue("")
        })
    }

    private fun initRecycler() {
        val clubAdapter = ClubAdapter(requireContext(), mainViewModel)

        val datas = mutableListOf<Club>()

        datas.add(Club(R.drawable.ic_b1nd,"?????????","??????, ??????, ???????????? ??????. B1nd"))
        datas.add(Club(R.drawable.ic_ducami,"?????????","????????? ?????? ?????? ?????? ?????????"))
        datas.add(Club(R.drawable.ic_3d,"??????","3d ????????? = ??????, ?????? = 3d ?????????"))
        datas.add(Club(R.drawable.ic_alt,"??????","?????? ?????? ?????????"))
        datas.add(Club(R.drawable.ic_today,"?????? ??????","?????? ????????? ?????????????"))
        datas.add(Club(R.drawable.ic_cns,"CNS","?????? ?????? ????????? ?????? ?????????"))
        clubAdapter.datas.addAll(datas)

        binding.rvClub.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        clubAdapter.notifyDataSetChanged()

        binding.rvClub.adapter = clubAdapter
    }

    private fun initFreeRecycler() {
        val clubAdapter = ClubAdapter(requireContext(), mainViewModel)

        val freeDatas = mutableListOf<Club>()

        freeDatas.add(Club(R.drawable.ic_ind,"??????","????????? ?????????"))
        freeDatas.add(Club(R.drawable.ic_badminton,"????????????","????????? ???????????? ?????????"))
        freeDatas.add(Club(R.drawable.ic_bicycle,"?????????","????????? ?????????"))
        clubAdapter.datas.addAll(freeDatas)

        binding.rvFreeClub.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        clubAdapter.notifyDataSetChanged()

        binding.rvFreeClub.adapter = clubAdapter
    }


}