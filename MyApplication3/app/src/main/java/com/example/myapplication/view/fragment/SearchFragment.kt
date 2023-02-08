package com.example.myapplication.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSearchBinding
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSearch.setOnClickListener {
            searchViewModel.keyword.postValue(binding.etSearch.text.toString())
            searchViewModel.searchPost()
        }
    }

}