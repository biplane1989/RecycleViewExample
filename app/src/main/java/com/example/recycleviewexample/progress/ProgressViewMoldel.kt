package com.example.demorecyclerview.progress

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recycleviewexample.progress.ProgressData
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProgressViewModel : ViewModel() {

    private val _list = MutableLiveData<List<ProgressData>>()
    val list: LiveData<List<ProgressData>> get() = _list
    val listData = ArrayList<ProgressData>()

    init {
        viewModelScope.launch {
            val result = mutableListOf<ProgressData>()
            for (i in 0 until 10) {
                val data = ProgressData("Item $i", 0)
                result.add(data)
                startUpdate(i)
            }

//            _list.value = result

            listData.addAll(result)
            _list.value = listData
        }
    }

    fun deleteItem() {
//        listData.removeAt(10)
//        _list.value = listData
        val listCopy = ArrayList(listData)
        val iterator: MutableIterator<ProgressData> = listCopy.iterator()
        var index = 0
        while (iterator.hasNext()) {
            index++
            val value = iterator.next()
            if (index == 9) {
                iterator.remove()
            }
        }

        _list.value = listCopy
    }

    private fun startUpdate(index: Int) {
        /*viewModelScope.launch {
            while (true) {
                val data = _list.value?.get(index)
                delay(200 + index * 20L)
                data?.let {
                    updateProgress(it, it.progress + 1)
                    if (it.progress >= 100)
                        return@launch
                }
            }
        }*/
    }

    private fun updateProgress(data: ProgressData, progress: Int) {
        /*val value = _list.value
        if (value != null) {
            val result =  ArrayList(value)

            // Remove old item
            val index = result.indexOf(data)
            result.removeAt(index)

            // Add new Item with new progress
            val newData = data.copy()
            newData.progress = progress
            result.add(index, newData)

            // Update list
            _list.value = result
        }*/
    }
}