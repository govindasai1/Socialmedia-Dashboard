package com.example.FlightBookingSystem

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

data class Flight (var flightNumber:String,var source:String,var destination:String,var departureTime:String,var arrivalTime:String)
data class Passenger(var id:String, var name:String, var flights: MutableList<Flight>)
data class FlightDet(var source:String,var destination:String,var departureTime:String)
var timeCalObject=TimeCalculation()
class FlightBookingSystem {
    var PassengersList: MutableList<Passenger> = mutableListOf()
    var BookingSystemFlig: MutableList<Flight> = mutableListOf()
    var BookingSystemPass: MutableList<Passenger> = mutableListOf()


    fun BookingFlight(passId:String,Flight:String){
        var list=BookingSystemFlig.filter { it.flightNumber.equals(Flight) }
        BookingSystemPass.map { if(it.id.equals(passId)){
            it.flights.addAll(list)
            println("flight booked $BookingSystemPass")
        }
        }
    }
    fun cancelFlight(passId:String,flightNumber: String){

        BookingSystemPass.map { if(it.id.equals(passId)){
            it.flights.removeIf { it.flightNumber.equals(flightNumber) }
            println(BookingSystemPass)
        }
        }

        println(PassengersList)
    }
    fun getTotalTravelTime(passId: String){
        var totalTime:Float=0f
        var list: List<Passenger> =BookingSystemPass.filter { it.id.equals(passId)}
        if(list.isNotEmpty()){
            list.map { it.flights.map { totalTime+= timeCalObject.timeTaken(it.departureTime,it.arrivalTime) } }
            println("total travel time is $totalTime")
        }

    }
    fun addingFlights(flight:Flight){
        var booked=BookingSystemFlig.add(flight)
        if(booked) println("flights added to booking list  $BookingSystemFlig")

        else println("not added")
    }
    fun removeFlights(flightId:String){
        var book: Boolean =BookingSystemFlig.removeIf { it.flightNumber.equals(flightId) }
        if(book) println("flight removed $BookingSystemFlig")
        else println("flight not removed")
    }
    fun addPassengers(pasenger:Passenger){
        var booked=BookingSystemPass.add(pasenger)
        if(booked) println("Passenger added to booking list $BookingSystemPass")
        else println("not added")
    }
    fun removePassenger(passId:String){
        var book=BookingSystemPass.removeIf { it.id.equals(passId) }
        if(book) println("pasenger removed $BookingSystemPass")
        else println("pasenger not removed")
    }
    fun searchFlight(flightDet:FlightDet){
        var searh: List<Flight> =BookingSystemFlig.filter { it.source.equals(flightDet.source) && it.destination.equals(flightDet.destination) && it.departureTime.equals(flightDet.departureTime) }
        println(searh)
    }
    fun passDetails(passId:String){
        var pass=BookingSystemPass.filter { it.id.equals(passId) }
        println(pass)
    }
    fun allPassengers(){
        println(BookingSystemPass)
    }
    fun flightDetails(flightId:String): List<Flight> {
        var flight: List<Flight> =BookingSystemFlig.filter { it.flightNumber.equals(flightId) }
        return (flight)
    }
    fun getPassengerCountByFlight(flightId:String){
        var list: List<Passenger> =PassengersList.filter { it.flights.isNotEmpty()  }
        var count=0
        list.map { (it.flights.map { if(it.flightNumber.equals(flightId)){count++ } }) }
        println(count)
    }
    fun getShortestFlight(flights: List<Flight>): Flight?{
        if(flights.isEmpty()) return null
        else{
            var shortFlight:Flight?=null
            for(Flight in flights){
                var List: List<Flight> = flights.sortedBy { timeCalObject.timeTaken(it.departureTime,it.arrivalTime) }
                shortFlight=List[0]
            }
            return shortFlight
        }
    }
    fun processBookings(passengers:List<Passenger>) = runBlocking {
        println(passengers)
        var asyn=async{
            for(passenger in passengers){
            var passId = passenger.id
            var flight =passenger.flights
            println("<$passId , $flight>")
        }}
       asyn.await()
    }
}


