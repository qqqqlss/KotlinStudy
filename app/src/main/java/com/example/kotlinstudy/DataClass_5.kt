package com.example.kotlinstudy

//2. data class

data class Ticket(val companyName:String, val name: String, var date:String, var seatNumber:Int)
//toString(), hashCode(), equals(), copy() <-포함

class TicketNormal(val companyName:String, val name: String, var date:String, var seatNumber:Int)

fun main(){
    val ticketA = Ticket("koreanAir", "joyceHong", "2020-02-16",14)
    val ticketB = TicketNormal("koreanAir", "joyceHong", "2020-02-16",14)
    println(ticketA)
    println(ticketB)
}