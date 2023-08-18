package com.example.Imbd

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

//
//import kotlinx.coroutines.*
//
//fun main() = runBlocking{
//    val s=launch {
//        val call1= async {  call1() }
//        val sss=call1.await()
//
//        val call2= call2()
//        println("hello ${call1.await()} and $call2")
//    }
//
//}
//suspend fun call1():Int{
//
//        delay(2000)
//        println("this is call1")
//    return 11
//}
//suspend fun call2():Int{
//    delay(2000)
//    println("this is call2")
//    return 43
//}
fun main()= runBlocking {
    var sum=async { adding(1,2) }
    var mul=async { multiply(1,2) }
    println(sum.await())
    println(mul)
}
suspend fun adding(n:Int,n1:Int):Int {
    delay(1100)
    return n +n1
}
suspend fun multiply(n:Int,n1:Int) {
    delay(1100)
    println( n * n1 )}