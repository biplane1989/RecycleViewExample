package com.example.recycleviewexample.sticky

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutineexampleone.HomeViewModel
import com.example.demorecyclerview.sticky.StickHeaderItemDecoration
import com.example.recycleviewexample.R
import com.example.recycleviewexample.databinding.FragmentHomeBinding
import com.example.recycleviewexample.databinding.FragmentStickyBinding


class StickyFragment : Fragment() {

    private var _binding: FragmentStickyBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentStickyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = StickyAdapter()
        binding.rvDemo.adapter = adapter
        binding.rvDemo.layoutManager = LinearLayoutManager(binding.rvDemo.context)
        binding.rvDemo.addItemDecoration(StickHeaderItemDecoration(adapter))
        adapter.submitList(demoData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}