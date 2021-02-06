package com.example.recycleviewexample.sticky

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewexample.databinding.HeaderItemBinding

class HeaderViewHolder(val binding: HeaderItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun build(data: MyData) {
        binding.tvHeader.text = data.title
    }

    companion object {
        fun create(paretn: ViewGroup): HeaderViewHolder {
            return HeaderViewHolder(HeaderItemBinding.inflate(paretn.getLayoutInflate(), paretn, false))
        }
    }

}