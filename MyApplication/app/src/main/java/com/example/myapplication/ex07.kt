package com.example.myapplication

//람다 함수와 고차 함수
fun main() {
var data1: String = "ryu"
//data1 = null   오류!!

var data2: String? = "ryu"      //널 허용
data2 = null

//.?
var length = data2?.length      //널 허용 변수이기때문에 data2.length  하면 널포인트익셉션

//?:
var data: String? = "kkang"
println("data = $data : ${data?.length?:-1}")
data = null
println("data = $data : ${data?.length?:-1}")

//!! 일부러 널포인트 익셉션 유발함    


}