package com.example.recycleviewexample.progress

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewexample.databinding.HeaderItemBinding
import com.example.recycleviewexample.databinding.ItemProgressBinding
import com.example.recycleviewexample.sticky.MyData
import com.example.recycleviewexample.sticky.getLayoutInflate
import java.util.*

class ProgressViewHolder(val binding: ItemProgressBinding) : RecyclerView.ViewHolder(binding.root) {

    fun build(data: ProgressData) {
        binding.title.text = data.title
    }

    fun updateProgress(progress: Int) {
        binding.progress.text = "$progress"
    }

    companion object {
        fun create(paretn: ViewGroup): ProgressViewHolder {
            return ProgressViewHolder(ItemProgressBinding.inflate(paretn.getLayoutInflate(), paretn, false))
        }
    }

}