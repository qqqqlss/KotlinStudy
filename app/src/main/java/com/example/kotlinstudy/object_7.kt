package com.example.kotlinstudy

//4. Object
//어디서 사용하든 처음 컴파일할 때 만들어진 인스턴스 하나!(싱글톤 패턴을 적용한 클래스)

//Singleton Pattern
object CarFactory{
    val cars= mutableListOf<Car>()
    fun makeCar(horsePower: Int):Car{
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower:Int)

fun main(){
    val car= CarFactory.makeCar(10)
    val car2= CarFactory.makeCar(200)

    println(car)
    println(car2)
    println(CarFactory.cars.size.toString())
}