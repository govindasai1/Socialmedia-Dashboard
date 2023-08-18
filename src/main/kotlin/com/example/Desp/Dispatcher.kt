package com.example.Desp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking{
    println(Thread.currentThread().name)
    launch (Dispatchers.Default){
        println(Thread.currentThread().name)
        delay(1000)
        println("-->   ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) {
        println(" uncon ${Thread.currentThread().name}")
//        delay(1000)
        println(" uncon ${Thread.currentThread().name}")

    }
    launch (Dispatchers.IO){
        println(" io ${Thread.currentThread().name}")
        delay(1000)
        println(" io ${Thread.currentThread().name}")
    }
}