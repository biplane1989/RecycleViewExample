package com.example.coroutineexampleone

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

class HomeViewModel : ViewModel() {

     val TAG = "TAG"
     private val _number = MutableLiveData<Int>()
     val number: LiveData<Int> = _number

     init {
     }

}