package com.example.myapplication.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemClubBinding
import com.example.myapplication.databinding.ItemPostBinding
import com.example.myapplication.network.model.Club
import com.example.myapplication.network.model.Post



class PostAdapter(private val context: Context) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    var datas = mutableListOf<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int {
        Log.d("getItemCount", datas.size.toString())
        return datas.size
    }

    inner class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post) {

            binding.root.setOnClickListener {

            }



            binding.title.text= item.title
            //Glide.with(context)
            //    .load(item.logo)
            //    .into(binding.icProfile)
            binding.postDetail.text = item.detail
            binding.viewer.text = item.view.toString()
            binding.postdate.text=item.createTime.toString()
        }
    }
}