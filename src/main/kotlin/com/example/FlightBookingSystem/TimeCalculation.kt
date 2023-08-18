package com.example.FlightBookingSystem

import kotlinx.coroutines.async

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class TimeCalculation {
    fun timeTaken(departureTime: String, arrivalTime: String):Float {
        val startTime = LocalTime.parse(departureTime, DateTimeFormatter.ofPattern("HH:mm")).toSecondOfDay()
        println(startTime)
        val endTime = LocalTime.parse(arrivalTime, DateTimeFormatter.ofPattern("HH:mm")).toSecondOfDay()
        var time: Float = ((endTime - startTime) / 3600f)
        return time
    }
    fun processBookings(passengers:List<Passenger>)= runBlocking {
        var asyn = async {
            for (passenger in passengers) {
                var passId = passenger.id
                var flight = passenger.flights
//             delay(1000)
                println("< passengerId: $passId ,Flight: $flight>")
            }
        }
        println("processed bookings are")
        asyn.await()
    }
}

fun main(){
    var timeCalObject=TimeCalculation()
    println( timeCalObject.timeTaken("17:09","19:00"))

//    var flig= mutableListOf((Flight("1", "1", "1", "17:09", "21:20")),Flight("2", "2", "2", "02:00", "08:15"),Flight("21", "21", "21", "17:09", "19:00"),Flight("12", "12", "12", "10:00", "13:10"))
////    var pass: Passenger =Passenger("1","govindasai",flig[0])
//   var  passengers = listOf(
//        Passenger(
//            "P1",
//            "John Doe",
//            mutableListOf(
//                Flight("F1", "Source1", "Dest1", "08:30", "09:45"),
//                Flight("F2", "Source2", "Dest2", "10:00", "11:15")
//            )
//        ),
//        Passenger(
//            "P2",
//            "Jane Smith",
//            mutableListOf(
//                Flight("F3", "Source3", "Dest3", "12:00", "13:30")
//            )))
//     timeCalObject.processBookings(passengers)
}




