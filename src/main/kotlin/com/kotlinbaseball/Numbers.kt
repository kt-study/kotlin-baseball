package com.kotlinbaseball

class Numbers(val num1: Int, val num2: Int, val num3: Int) {
    fun checkResult(input: Int): String {
        var strike = 0;
        var ball = 0;
        val inputNum1 = input / 100
        val inputNum2 = (input - inputNum1 * 100) / 10
        val inputNum3 = (input - inputNum1 * 100 - inputNum2 * 10)


        return "";
    }
}

fun createNumbers(): Numbers {
    var num1 = (1..9).random()
    var num2 = (1..9).random()
    var num3 = (1..9).random()

    while (num1 == num2 || num2 == num3 || num3 == num1) {
        num1 = (1..9).random()
        num2 = (1..9).random()
        num3 = (1..9).random()
    }

    return Numbers(num1, num2, num3)
}
