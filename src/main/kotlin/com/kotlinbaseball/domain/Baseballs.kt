package com.kotlinbaseball.domain

import kotlin.random.Random

private const val BALL_COUNT: Int = 3

class Baseballs(
    val values: Set<Baseball> = initValues()
) {
}

fun initValues(): Set<Baseball> {
    val values = mutableSetOf<Int>()

    while (values.size < BALL_COUNT) {
        values.add(Random.nextInt(Baseball.MIN_NUMBER, Baseball.MAX_NUMBER))
    }

    return values.map { Baseball(it) }
        .toSet()
}
