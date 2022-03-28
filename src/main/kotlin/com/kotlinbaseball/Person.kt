package com.kotlinbaseball

data class Person(
    val name: String,
    val age: Int? = null
)

fun main() {
    val persons = listOf(Person("영희"), Person("철수", 25))
    val oldest = persons.maxByOrNull { it.age ?: 0 }
    val 영희 = Person("hi")
    println("나이가 가장 많은사람 : $oldest")
    println(영희.age)
    println(영희.name)

}
