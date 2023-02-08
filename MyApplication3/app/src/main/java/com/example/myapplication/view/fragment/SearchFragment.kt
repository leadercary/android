package com.example.myapplication.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSearchBinding
import com.example.myapplication.network.model.Club
import com.example.myapplication.network.model.Post
import com.example.myapplication.view.adapter.ClubAdapter
import com.example.myapplication.view.adapter.PostAdapter
import com.example.myapplication.viewmodel.SearchViewModel

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var searchViewModel: SearchViewModel

    lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
        inflater,
        R.layout.fragment_search,
        container,
        false
    )
        searchViewModel= SearchViewModel()
        searchViewModel.itemList.observe(viewLifecycleOwner, Observer {
            initRecycler(searchViewModel.itemList.value)
        })
        return binding.root
    }

    private fun initRecycler(datas: List<Post>?) {
        val postAdapter = PostAdapter(requireContext())

        if(!(datas.isNullOrEmpty())){
            postAdapter.datas.addAll(datas)
        }

        binding.rvSearch.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        postAdapter.notifyDataSetChanged()
        binding.rvSearch.adapter = postAdapter
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etSearch.setOnClickListener {
            binding.etSearch.isCursorVisible=true
        }

        binding.btnSearch.setOnClickListener {
            searchViewModel.keyword.postValue(binding.etSearch.text.toString())
            searchViewModel.searchPost()
        }
    }

}