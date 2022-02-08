package com.example.myapplication

fun main() {
    //Array - 배열표현  첫번째 매개변수는 배열의 크기, 두 번째 매개변수는 초깃값
    //val data1: Array<Int> = Array(3, { 0 })
    val data1 = arrayOf<Int>(10, 20, 30)
    //data1[0] = 10
    //data1[1] = 20
    //sdata1.set(2, 30)

    println(
        """
            array size : ${data1.size}
            array data : ${data1[0]},${data1[1]},${data1.get(2)}
        """.trimIndent()
    )

    //List, Set, Map 가변 클래스와 불변 클래스로 나뉜다.
    var list = listOf<Int>(10, 20, 30)


    println(
        """
            list size : ${list.size}
            list data : ${list[0]},${list.get(1)},${list.get(2)}
        """.trimIndent()
    )


    var mutableList = mutableListOf<Int>(10, 20, 30)
    mutableList.add(3, 40)
    mutableList.set(0, 50)

    println(
        """
            list size : ${mutableList.size}
            list data : ${mutableList[0]},${mutableList.get(1)},${mutableList.get(2)},${mutableList.get(3)}
        """.trimIndent()
    )


    var map = mapOf<String, String>(Pair("one", "hello"), "two" to "world")
    println(
        """
            map size : ${map.size}
            map data : ${map.get("one")}, ${map.get("two")}
        """.trimIndent()
    )
}