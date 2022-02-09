package com.example.myapplication

fun main() {


    /*if (data>0) {
        println("data > 0")
    } else {
        println("data <= 0")
    }*/

    //코틀린은 if~else 를 삼항 연산자 처럼쓸 수 있다.
    /*val result = if(data>0) {
        println("data>0")
        true
    }else{
        println("data <= 0")
        false
    }
    println(result);*/

    var data: Any = 10;

    when(data) {
        is String -> println("data is String")
        in 1..10 -> println("data is 10")
        20, 30 -> println("data is 20 or 30")
        else ->
            println("data is not valid data")
    }
    //when 또한 if~else 문과 같이 표현식처럼 쓸 수 있다.
    
    /*
    for(i in 1..10){}  -> 1부터 10까지 1씩증가
    for(i in 1 until 10){} -> 1부터 9까지 1씩증가 (10미포함)
    for(i in 2..10 step 2){} -> 2부터 10까지 2씩증가
    for(i in 10 downTo 1){} -> 10부터 1까지 1씩 감소
    */

    //배열의 갯수만큼 반복
    var datas = arrayOf<Int>(10, 20, 30)
    //indices 는 컬렉션 타입의 인덱스값을 의미한다.
    for (i in datas.indices) {
        print(datas[i])
        if(i !== datas.size - 1) print(",")
        println()
    }

    //데이터와 인덱스값을 함께 가져와야 할 때.
    for((index, value ) in datas.withIndex()) {
        println("$index 번째 데이타는 $value");
    }
}