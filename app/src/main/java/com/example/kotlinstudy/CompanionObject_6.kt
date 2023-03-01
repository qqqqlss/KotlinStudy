package com.example.kotlinstudy

//3. companion Object
//private property나 메서드를 읽어올 수 있도록 함 ( 자바의 static 역할)
class Book private constructor(val id:Int, val name:String){
    companion object BookFactory:IdProvider{
        override fun getId(): Int {
            return 444
        }

        val myBook="new book"

        fun create()= Book(getId(), myBook)
    }
}

interface IdProvider{
    fun getId() :Int
}

fun main(){
    val book = Book.BookFactory.create() //Companion 생략 가능

    val bookId= Book.getId()

    println("${book.id} ${book.name}")
}