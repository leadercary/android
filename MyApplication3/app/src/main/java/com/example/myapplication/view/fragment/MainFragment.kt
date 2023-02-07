package com.example.myapplication.view.fragment

import android.os.Bundle
import com.example.myapplication.databinding.FragmentMainBinding
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.viewmodel.MainViewModel
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
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
        binding.adminBtn.setOnClickListener{
            (activity as MainActivity).switchFragment(LoginFragment())
        }
        binding.bgSearch.setOnClickListener {
            (activity as MainActivity).switchFragment(SearchFragment())
        }
        initRecycler()
        initFreeRecycler()
    }

    private fun initRecycler() {
        val clubAdapter = ClubAdapter(requireContext())

        val datas = mutableListOf<Club>()

        datas.add(Club(R.drawable.ic_b1nd,"바인드","학교, 학생, 학부모를 잇다. B1nd"))
        datas.add(Club(R.drawable.ic_ducami,"두카미","대소고 공식 교육 봉사 동아리"))
        datas.add(Club(R.drawable.ic_3d,"삼디","3d 프린터 = 삼디, 삼디 = 3d 프린터"))
        datas.add(Club(R.drawable.ic_alt,"알트","학교 홍보 동아리"))
        datas.add(Club(R.drawable.ic_today,"오늘 하루","오늘 하루는 어땠나요?"))
        datas.add(Club(R.drawable.ic_cns,"CNS","입학 원서 사이트 개발 동아리"))
        clubAdapter.datas.addAll(datas)

        binding.rvClub.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        clubAdapter.notifyDataSetChanged()

        binding.rvClub.adapter = clubAdapter
    }

    private fun initFreeRecycler() {
        val clubAdapter = ClubAdapter(requireContext())

        val freeDatas = mutableListOf<Club>()

        freeDatas.add(Club(R.drawable.ic_ind,"인디","디자인 동아리"))
        freeDatas.add(Club(R.drawable.ic_badminton,"배드민턴","대소고 배드민턴 동아리"))
        freeDatas.add(Club(R.drawable.ic_bicycle,"자전거","자전거 동아리"))
        clubAdapter.datas.addAll(freeDatas)

        binding.rvFreeClub.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        clubAdapter.notifyDataSetChanged()

        binding.rvFreeClub.adapter = clubAdapter
    }


}