package com.example.recycleviewexample.progress

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demorecyclerview.progress.ProgressViewModel
import com.example.demorecyclerview.sticky.StickHeaderItemDecoration
import com.example.recycleviewexample.R
import com.example.recycleviewexample.databinding.FragmentProgressBinding
import com.example.recycleviewexample.databinding.FragmentStickyBinding
import com.example.recycleviewexample.sticky.StickyAdapter
import com.example.recycleviewexample.sticky.demoData


class ProgressFragment : Fragment() {

    private var _binding: FragmentProgressBinding? = null
    private val binding get() = _binding!!
    private val progressViewHolder: ProgressViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentProgressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ProgressAdapter()
        binding.rvProgress.adapter = adapter

        progressViewHolder.list.observe(viewLifecycleOwner) {

            adapter.submitList(it)
        }

        binding.delete.setOnClickListener {
            progressViewHolder.deleteItem()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}