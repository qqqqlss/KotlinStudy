package com.example.kotlinstudy

//1. Lambda
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
// 1) 메소드의 파라미터로 넘겨줄 수가 있다. fun maxBy(a :Int)
// 2) return 값으로 사용할 수가 있다.

// 람다의 기본 정의
// val lambdaName :Type = {argumentList -> codeBody}

val square: (Int) -> (Int) ={ number-> number*number} // 타입 추론을 위해 앞이나 뒤 적어도 한 곳에는 타입 명시 필요

val nameAge={name:String,age:Int->
    "my name is ${name} I'm ${age}"
}

// 1-2.  확장 함수
val pizzaIsGreat:String.()->String = {//this-String
    this + " pizza is the best!"
}

fun extendString(name:String, age:Int):String { //this-name, it-age
    val introduceMyself :String.(Int)-> String={"I am ${this} and ${it} years old"}
    return name.introduceMyself(age)
}   // this - 시작함수를 콜하는 오브젝트, it - 하나가 들어가는 파라미터는 it으로 생략 가능

// 1-3. 람다의 Return
// val calculateGrade : Int -> String={}    에러
val calculateGrade : (Int) -> String={// Input은 여러개 일수 있지만 Return 값은 하나의 타입
    when(it){   // else 없으면 에러(경우의 수를 모두 포함해야 함 null 반환 안하게)
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100-> "perfect"
        else-> "Error"
    }
}

// 1-4. 람다를 표현하는 여러 가지 방법(4가지가 있지만 2가지만 표현)
fun invokeLambda(lambda : (Double)->Boolean) :Boolean{
    return lambda(5.2343)
}


fun main(){
    //1. Lambda
    println(square(12))
    println(nameAge("joyce",99))

    // 1-2.  확장 함수
    val a="joyce said"
    val b="mac said"

    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    println(extendString("ariana",27))

    // 1-3. 람다의 Return
    println(calculateGrade(97))
    println(calculateGrade(999))

    // 1-4. 람다를 표현하는 여러 가지 방법(4가지)
    val lambda={number:Double ->
        number==4.3213
    }
    println(invokeLambda(lambda))
    println(invokeLambda({it > 3.22}))
    println(invokeLambda(){it > 3.22})
    println(invokeLambda{it >3.22}) // 마지막 파라미터가 lambda식일 때, it은 하나 들어가는 input파라미터
}


