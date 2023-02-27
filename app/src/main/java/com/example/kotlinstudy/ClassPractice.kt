package com.example.kotlinstudy

// 코틀린과 자바의 다른점(클래스)
// 코틀린 파일 이름이랑 class랑 일치안해도 됨  / 자바는 일치해야함
// 코틀린은 한 파일에 클래스를 여러개 만들 수 있음. / 자바는 한개만!

open class Human constructor(val name:String="Anonymous"){   //주생성자  / constructor- 생성자 / ="Anonymous"는 ()로 생성시 name default 값 설정 )
    //자바 Human(){...}
    //val name = name   중복해서 들어가기 때문에 위 생성자에 val 추가하면 같은 효과
    init{   //주생성자의 일부 -> 생성과 동시에 실행
        println("New human hasbeen born!!")
    }

    //overloading (부생성자)        실행순서 주생성자-> 부생성자
    constructor(name:String, age:Int) :this(name){  // this를 통해 주생성자의 매개변수를 위임 받아야함. 없으면 오류
        println("My name is ${name}, ${age}years old" )
    }

    fun eatingCake(){
        println("This is so YUMMYYY~~~~")
    }

    open fun singASong(){ // open 안하면 Korean에서 오버라이딩 불가.
        println("lalala")
    }
}

class Korean: Human(){  // 상속  / 부모 클래스에 open 필요(없으면 오류) / 자바는 extends 사용
    override fun singASong(){
        super.singASong() //    super - 부모 호출.
        println("라라랄")
        println("My name is : ${name}") //  부모값 받아옴.
    }
}

fun main(){
    //자바는 생성자 new Human()
    val human =Human("minsu") //new 필요없음

    val stranger = Human()  // 매겨변수 default 값으로 생성 name->Anonymous

    val mom = Human("Kuri", 52)

    human.eatingCake()

    println("this human's name is ${human.name}")
    println("this human's name is ${stranger.name}")

    val korean=Korean()
    korean.singASong()
}