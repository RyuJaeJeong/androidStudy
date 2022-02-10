package com.example.myapplication

//주생성자와 보조생성자로 나눌수있다.
//보조생성자로 객체를 사용 할때 :this()로 주 생성자와 연결해줘야한다.
//생성자의 매게변수를 클래스의 멤버변수로 선언 할수 있다. 매게변수에 val, var로 선언해서
class User constructor(){
    init {
        println("i am init....")
    }
    //생성자, 변수, 함수, 클래스
    var name = "kkang"
    constructor(name:String) : this() {
        this.name = name
    }

    fun someFun(){
        println("name : $name")
    }

    class SomeClass{}
}

fun main() {
    val user = User("Ryu")
    user.someFun()
}