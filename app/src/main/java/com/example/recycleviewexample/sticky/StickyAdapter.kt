package com.example.recycleviewexample.sticky


import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerview.sticky.StickHeaderItemDecoration

const val HEADER: Int = 1
const val ITEM: Int = 0


class StickyAdapter : ListAdapter<MyData, RecyclerView.ViewHolder>(DiffStickyUnti()), StickHeaderItemDecoration.StickyHeaderInterface {

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.header) HEADER else ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HEADER) HeaderViewHolder.create(parent)
        else ItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (holder is HeaderViewHolder) holder.build(item)
        else if (holder is ItemViewHolder) holder.build(item)
    }

//    override fun getHeaderPositionForItem(itemPosition: Int): Int {
//        for (i in itemPosition downTo 0) {
//            val item = getItem(i)
//            if (item.header) return i
//        }
//        return RecyclerView.NO_POSITION
//    }
//
//    override fun getHeaderViewHolder(parent: ViewGroup, headerPosition: Int): RecyclerView.ViewHolder {
//        /*val viewType = getItemViewType(headerPosition)
//        if (viewType == HEADER){
//
//        }*/
//        HeaderViewHolder.create(parent)
//    }
//
//    override fun bindHeaderData(holder: RecyclerView.ViewHolder?, headerPosition: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun isHeader(itemPosition: Int) = getItem(itemPosition).header

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        for (i in itemPosition downTo 0) {
            val item = getItem(i)
            if (item.header) return i
        }
        return RecyclerView.NO_POSITION
    }

    override fun getHeaderViewHolder(parent: ViewGroup, headerPosition: Int): RecyclerView.ViewHolder {
        return HeaderViewHolder.create(parent)
    }

    override fun bindHeaderData(holder: RecyclerView.ViewHolder?, headerPosition: Int) {
        if (holder is HeaderViewHolder) holder.build(getItem(headerPosition))
    }

    override fun isHeader(itemPosition: Int) = getItem(itemPosition).header


}

class DiffStickyUnti : DiffUtil.ItemCallback<MyData>() {
    override fun areItemsTheSame(oldItem: MyData, newItem: MyData) = oldItem === newItem

    override fun areContentsTheSame(oldItem: MyData, newItem: MyData) = oldItem == newItem
}