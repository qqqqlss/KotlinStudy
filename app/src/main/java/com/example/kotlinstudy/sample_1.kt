package com.example.kotlinstudy

fun main(){
    //함수
    helloWorld()
    println(add(4,6))

    //val VS var
    valVar()

    //String Template
    stringTemplate()

    //4. 조건식 (if, when)
    checkNum(1)

    //5. Expression vs Statement -> 자바와 코틀린의 차이
    //값을 만드면 expression, 코틀린의 모든 함수는 expressio(반환 값이 없어도 Unit 반환)
    //자바는 statement, expression  둘다 있음

    //6. Array and List
    array()

    //7. 반복문 (For, While)
    forAndWhile()

    //8. Nullable, NonNull
    nullcheck()

    //9. Classsms -> ClassPratice.kt 에서 확인!

}

//1. 함수
fun helloWorld() : Unit { //void -> Unit 생략 가능
    println("Hello World")
}

fun add(a: Int, b:Int):Int { // 타입 명시 필수!, int ㄴ 타입 첫글자 대문자
    return a + b
}

//2. val vs var
//val = value, 안에 값 못 바꿈
fun valVar(){
    val a:Int=10
    var b:Int=9
    // a=100 오류

    val ex1:String // 타입 명시 후 값 넣어줌. 값 변경 불가.
    var ex2:Int
    ex1="s"
    // ex1="t" 오류
    println(ex1)

    val c=100 //변수 선언시 값 넣으면 타입 생략 가능, 자동 배정
    var d=10 // ""
    var name="joyce"
}

//3. String Template
fun stringTemplate(){
    val name="Joyce"
    val lastName="Hong"
    println("my name is ${name + lastName}") // ${변수} {}생략 가능, 띄어쓰기 안하려면 필요
    println("is this true? ${1==0}") //"is this true? false" 출력
    println("this is 2\$a") // $출력하고 싶으면 escape 문자 \ 사용
}

// 4. 조건식
fun maxBy(a:Int, b:Int):Int{
    if (a>b){
        return a
    }else{
        return b
    }

}
fun maxBy2(a:Int, b:Int) = if(a>b) a else b //반환 타입 생략 가능, 자동 배정.

fun checkNum(score: Int){
    when(score){
        0-> println("this is 0")
        1-> println("this is 1")
        2,3 -> println("this is 2 or 3")
        //else 생략 가능
    }
    var b=when(score){
        1-> 1
        2-> 2
        else -> 3 // else 생략 불가. 다른 값 들어갈 수도 있기에.
    }
    println("b :  ${b}")

    when (score){ // ..으로 이상 이하 표현 between
        in 90..100 -> println("You are genius")
        in 10..80 -> println("not bad")
        else -> println("okay") //else 생략 가능
    }
}

// 6. Array and List
fun array(){ // 타입 명시 생략 가능
    val array=arrayOf(1,2,3) //Array<Int>
    val list= listOf(1,2,3) // List<Int>
    val array2 = arrayOf(1,"d",3.4f) // Array<Any>
    val list2 = listOf(1,"d",11L) //List<Any>

    //List는 immutable, array는 mutable
    array[0]=3 // 가능
    //list[0]=1 오류

    var result=list.get(0) // 커맨드 클릭시 상세코드 볼 수 있음 (라이브러리)
    println(result) //list 첫번째 원소 출력

    val arrayList= arrayListOf<Int>() // 배열 안의 값이 바뀌어도 주소값이 바뀌지 않기 때문에 val 가능
    arrayList.add(10)
    arrayList.add(20)
    // arrayList=arrayListOf()  오류
}

// 7. 반복문 (For,While)
fun forAndWhile(){
    val students= arrayListOf("joyce", "james", "jenny", "jennifer")

    for (name in students){
        println("$name")
    }
    for ((index, name) in students.withIndex()){ // index와 함께 순환
        println("${index+1} $name")
    }
    var sum=0
    for (i in 1..10 step 2){ //.. and step
        sum+=i
    }
    println(sum)
    for (i in 10 downTo 1) // downTo
    for (i in 1 until 100) sum+=1 // until -> 1~99

    var index=0
    while(index<10){
        println("current index : ${index}")
        index++
    }
}

// 8. Nullable / NonNull
fun nullcheck() {
    //NPE : Null Pointer Exception
    var name = "joyce"
    //var name :String = null       오류 (nonnull이라)
    var nullName: String? = null //not null type -> ? 통해 nullable

    // var nullNameInUpperCase=nullName.toUpperCase()  오류 (nonnull)
    var nullNameInUpperCase=nullName?.toUpperCase()  // ?  통해 nullable

    // ?:
    val lastName : String? =null
    val fullName =name +" "+ (lastName?: "No lastName") //lastName이 null이면 지정된 값 삽입
    println(fullName)

    //ignoreNulls(name) 오류

    // !!           <- 정말 확실하게 null이 안들어가는거 아닌면 쓰는 거 지양(오류나기 쉬움)
    fun ignoreNulls(str:String?){
        // val mNotNull:String = str    오류
        val mNotNull:String = str!! //str이 null이 아님을 보증! null값이 들어갈 일이 없음을 알려줌(컵파일러한테)

//        val email :String = "joycehongXXXX@nana.com"
//        email?.let{           불필요한 ?
//
//        }
        val email :String? = "joycehongXXXX@nana.com"
        email?.let{ // email이 null이 아니면 let{ 이거 } 를해라
            println("my email is ${email}")
        }
    }

    ignoreNulls(name)

}