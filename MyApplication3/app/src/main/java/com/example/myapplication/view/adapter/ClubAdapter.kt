package com.example.myapplication.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemClubBinding
import com.example.myapplication.network.model.Club
import com.example.myapplication.viewmodel.MainViewModel
import com.example.myapplication.viewmodel.SearchViewModel


class ClubAdapter(private val context: Context, vm: MainViewModel) :
    RecyclerView.Adapter<ClubAdapter.ClubViewHolder>() {
    private val mainViewModel = vm
    var datas = mutableListOf<Club>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        val view = ItemClubBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClubViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int {
        Log.d("getItemCount", datas.size.toString())
        return datas.size
    }

    inner class ClubViewHolder(private val binding: ItemClubBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Club) {
            binding.root.setOnClickListener {
                mainViewModel.onclick.postValue(item.title)
            }
            binding.tvTitle.text = item.title
            Glide.with(context)
                .load(item.logo)
                .into(binding.icProfile)
            binding.tvSub.text = item.sub

        }
    }
}