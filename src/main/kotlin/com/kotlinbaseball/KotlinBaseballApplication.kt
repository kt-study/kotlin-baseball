package com.kotlinbaseball

class KotlinBaseballApplication

fun main() {
    val baseball = Baseball(Computer())

    while(true) {
        baseball.start()
        baseball.play()
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val answer = readLine()

        if (answer.equals("2")) {
            return
        }
    }
}
