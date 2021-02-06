package com.example.recycleviewexample.sticky

data class MyData(

    val title: String, val header: Boolean)

val demoData by lazy {
    val result = mutableListOf<MyData>()
    for (i in 0 until 100) {
        if (i % 10 == 0) {
            result.add(MyData("Header $i", true))
        } else {
            result.add(MyData("Item $i", false))
        }
    }
    result
}