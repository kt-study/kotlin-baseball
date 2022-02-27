package com.kotlinbaseball

import com.kotlinbaseball.domain.BaseballGame

class KotlinBaseballApplication

fun main(args: Array<String>) {
    do {
        val baseballGame = BaseballGame()
        baseballGame.play()
    } while (baseballGame.playerWantNewGame())
}
