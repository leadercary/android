package com.example.myapplication.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSearchBinding
import com.example.myapplication.network.model.club
import com.example.myapplication.view.adapter.ClubAdapter
import com.example.myapplication.viewmodel.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_search,
            container,
            false
        )


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
    }

    private fun initRecycler() {
        val clubAdapter = ClubAdapter(requireContext())

        val datas = mutableListOf<club>()

        datas.add(club(R.drawable.ic_b1nd,"바인드","대소고aaa동아리"))
        datas.add(club(R.drawable.logo,"두카미","몰라"))

        clubAdapter.datas.addAll(datas)

        binding.rvClub.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        clubAdapter.notifyDataSetChanged()

        binding.rvClub.adapter = clubAdapter

    }

}