package com.kotlinbaseball.domain

class BaseballGameScore {

    private var strikeCount: Int = 0
    private var ballCount: Int = 0

    fun increaseBall() {
        ballCount += 1
    }

    fun increaseStrike() {
        strikeCount += 1
    }

    fun isNotThreeStrike(): Boolean {
        return strikeCount != 3
    }

    fun getBallCount(): Int {
        return ballCount
    }

    fun getStrikeCount(): Int {
        return strikeCount
    }
}
