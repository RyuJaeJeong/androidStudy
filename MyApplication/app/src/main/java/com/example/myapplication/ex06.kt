package com.example.myapplication

import android.location.Address

//데이터 클래스, 주생성자에 val var로 선언한 매개변수를 선언해 클래스의 멤버변수로 활용하는 것이 일반적임.
data class DataClass(var name:String, val email:String, val age: Int) {
     lateinit var address: String
     constructor(name: String, email: String, age: Int, address: String):this(name, email, age) {
         this.address = address
     }
}

fun main() {
    val obj1 = DataClass("ryu", "ryoojj8998@gmail.com", 27, "Daegu")
    val obj2 = DataClass("ryu", "ryoojj8998@gmail.com", 27, "Busan")
    obj1.name = "jae"
    println("obj1.equals(obj2) : ${obj1.equals(obj2)}")
    println("obj1.toString : ${obj1.toString()}")
}
