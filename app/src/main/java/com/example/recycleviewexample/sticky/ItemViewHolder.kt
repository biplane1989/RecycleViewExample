package com.example.recycleviewexample.sticky

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewexample.databinding.HeaderItemBinding
import com.example.recycleviewexample.databinding.StickyItemBinding

class ItemViewHolder(val binding: StickyItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun build(data: MyData) {
        binding.tvItem.text = data.title
    }

    companion object {
        fun create(paretn: ViewGroup): ItemViewHolder {
            return ItemViewHolder(StickyItemBinding.inflate(paretn.getLayoutInflate(), paretn, false))
        }
    }
}