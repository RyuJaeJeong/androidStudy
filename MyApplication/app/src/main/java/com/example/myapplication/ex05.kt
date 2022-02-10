package com.example.myapplication

//상속받을 경우 상위 클래스의 멤버 변수와 함수를 내꺼처럼 사용 할 수 있다.
//오버라이드를 통해 상위 클래스의 멤버 변수나 함수를 재정의 하는 것도 가능하다
open class Super {
    open var someData = 10
    open fun someFun() {
        println("i am super class function : $someData")
    }

}
class  sub: Super() {
    override fun someFun() {
        println("i am sub class function : $someData")
    }

}

fun main() {
    val obj = sub()
    obj.someFun();
}