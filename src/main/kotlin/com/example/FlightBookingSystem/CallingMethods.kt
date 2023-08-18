package com.example.FlightBookingSystem
var flightbookObj=FlightBookingSystem()
var timobj=TimeCalculation()
fun callingMethods(){

    println("1.BookFlight for custmor  2.cancel flight  3.gettotaltreveltime\n4.addFlights to booking System \n5.remove flights in booking System \n6.add passengers to booking System \n7.removepassengers to booking System \n8.searcflight in booking system\n9.passengerdetails in bookingsystem \n10.all passenger details\n11.flight details\n12.get shortest flight\n13.getbookings")
    var i= readln().toInt()
    when(i){
        1->{
            println("enter pass id")
            var id=readln()
            println("enter flight number")
            var flight= readln()
            flightbookObj.BookingFlight(id,flight)
        }
        2-> {
            println("enter pass id")
            var id = readln()
            println("enter flightNumber")
            var flightNumber= readln()
            flightbookObj.cancelFlight(id,flightNumber)
        }
        3->{println("enter pass id")
            var id = readln()
            flightbookObj.getTotalTravelTime(id)
        }
        4->{println("enter flight details")
            var flight:Flight= Flight(readln(),readln(),readln(),readln(),readln())
            flightbookObj.addingFlights(flight)
        }
        5->{println("enter flightNumber")
            var flightNumber= readln()
            flightbookObj.removeFlights(flightNumber)
        }
        6->{
            println("enter passenger id")
            var passid= readln()
            println("enter name")
            var name= readln()
            var fli:MutableList<Flight> = mutableListOf()
            var pas: Passenger =Passenger(passid, name,fli)
            flightbookObj.addPassengers(pas)
        }
        7->{println("enter pass id")
            var id = readln()
            flightbookObj.removePassenger(id)
        }
        8->{
            println("enter flit details")
            var flitdet:FlightDet= FlightDet(readln(), readln(), readln())
            flightbookObj.searchFlight(flitdet)
        }
        9->{println("enter pass id")
            var id = readln()
            flightbookObj.passDetails(id)
        }
        10->{
            flightbookObj.allPassengers()
        }
        11->{println("enter flightNumber")
            var flightNumber= readln()
           println(flightbookObj.flightDetails(flightNumber))
        }
        12->{
           var list: List<Flight> = flightbookObj.BookingSystemFlig
            var flight: Flight? = flightbookObj.getShortestFlight(list)
            println(flight)
        }
        13->{
            timobj.processBookings(flightbookObj.BookingSystemPass)
        }
    }

}
fun main(){
    do{
        callingMethods()
        println("press 1 to do bookings or cancel bookings ")
        var input= readln().toInt()
    }
        while (input==1)
}