package com.example.myapplication


//val(혹은 var) 변수명 : 타입 = 값;
//최상위에 선언된 변수나 클래스의 멤버 변수는 선언과 동시에 초기값을 할당해야함.
//코틀린에서는 모든 타입이 객체다, int 타입에 null을 넣을 수 있음
//lateinit 으로 초기화를 유보 할 수 있으나 var 키워드로 선언해야하면 정수형, 실수형 변수는 불가
//Any타입 : 모든 타입이 가능
//Unit타입 : 반환문이 없음을 명시적으로 나타낼때 사용
//Nothing타입 : null이나 예외를 반환하는 함수
val data1 = 10;
var data2:Int? = 10;
//?표시하면 널 허용
//?표시하지 않으면 널 불허용
//fun함수명(매개변수명:타입): 반환타입 {...}
fun main() {
    //data1 = 20;   "can not be reassigned" val로 선언된 변수는 바꿀수 없음
    data2 = 20;
    fun sum(no: Int): Int {
        var sum = 0
        for(i in 1..no) {
            sum += i
        }
        return sum
    }

    val name: String = "kkang"
    println("name : $name, sum: ${sum(10)}, plus : ${10 + 20}")

}

