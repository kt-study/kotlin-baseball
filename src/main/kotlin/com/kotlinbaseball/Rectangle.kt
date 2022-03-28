package com.kotlinbaseball

import java.util.*

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean = height == width
}

fun createRandomRectangle() : Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

fun main() {
    val r = createRandomRectangle()
    println(r.width)
    println(r.height)
}