package com.example.recycleviewexample.progress


import android.annotation.SuppressLint
import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

const val UPDATE_PROGRESS = 2

class ProgressAdapter : ListAdapter<ProgressData, ProgressViewHolder>(DiffProgressUnit()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgressViewHolder {
        return ProgressViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ProgressViewHolder, position: Int) {
        holder.build(getItem(position))
    }

    override fun onBindViewHolder(holder: ProgressViewHolder, position: Int, payloads: MutableList<Any>) {

        val status = payloads.firstOrNull()
        if (status == UPDATE_PROGRESS) {
            // update 1 phan
            holder.updateProgress(getItem(position).progress)
        } else {
            // update full
            onBindViewHolder(holder, position)
        }
        super.onBindViewHolder(holder, position, payloads)
    }
}

class DiffProgressUnit : DiffUtil.ItemCallback<ProgressData>() {
    override fun areItemsTheSame(oldItem: ProgressData, newItem: ProgressData): Boolean {   // so sanh 2 object
        return oldItem.title == newItem.title       // check theo ID
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ProgressData, newItem: ProgressData): Boolean {    // muon dung payload thi ham nay luon tra false
//        if (oldItem.progress != newItem.progress) return false
//        else return oldItem == newItem

        return false
    }

    override fun getChangePayload(oldItem: ProgressData, newItem: ProgressData): Any? {

        if (oldItem.title == oldItem.title && oldItem.progress != newItem.progress) return UPDATE_PROGRESS        // muon update cai nao thi check cai do khac, con lai bang nhau
        return null
    }

}