package com.kotlinbaseball

import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*

@SpringBootApplication
class KotlinBaseballApplication

fun main() {
//    val kb = Scanner(System.`in`)
//    baseballGame(kb)
    val inputNum1 = 321 / 100
    val inputNum2 = (321 - inputNum1 * 100) / 10
    val inputNum3 = (321 - inputNum1 * 100 - inputNum2 * 10)

    println(inputNum1)
    println(inputNum2)
    println(inputNum3)
}

fun baseballGame(kb: Scanner) {
    var newGame = true
    while (newGame) {
        eachGame(kb, createNumbers())
        newGame = checkMoreGame(kb)
    }
}

fun eachGame(kb: Scanner, answer: Numbers) {
    var gameResult = true
    while (gameResult) {
        print("숫자를 입력해주세요 : ")
        val input = kb.nextInt()
        println(answer.checkResult(input))
    }

    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun checkUserInput(kb: Scanner) : Boolean {
    var correctInput = true
    while(correctInput) {
        print("숫자를 입력해주세요 : ")
        correctInput = isCorrectInput(kb.nextInt())
    }
}

fun isCorrectInput(input: Int): Boolean {
    if (input < 100 || input > 999) {
        return false
    }

    val n1 = input / 100
    val n2 = (input - n1 * 100) / 10
    val n3 = (input - n1 * 100 - n2 * 10)

    if (n1 == n2 || n2 == n3 || n3 == n1) {
        return false
    }
    return true
}

fun checkMoreGame(kb: Scanner) : Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val input = kb.nextInt()
    if (input == 1) {
        return true
    }
    if (input == 2) {
        return false
    }
    throw IllegalArgumentException()
}
