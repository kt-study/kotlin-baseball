package com.kotlinbaseball

class Computer (
    var target: BaseballNumber
) {

    constructor(): this(BaseballNumber.of())

    fun initNumber() {
        target = BaseballNumber.of()
    }

    fun checkBaseballNumber(number: BaseballNumber): Boolean {
        val strikeOrBall = target.checkBaseballNumber(number)

        if (strikeOrBall["strike"] == 3) {
            println("${strikeOrBall["strike"]}스트라이크")
            println("${strikeOrBall["strike"]}개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return true
        }

        if (strikeOrBall["strike"] != 0 && strikeOrBall["ball"] != 0) {
            println("${strikeOrBall["ball"]}볼 ${strikeOrBall["strike"]}스트라이크")
            return false
        }

        if (strikeOrBall["ball"] != 0) {
            println("${strikeOrBall["ball"]}볼")
            return false
        }

        if (strikeOrBall["strike"] != 0) {
            println("${strikeOrBall["strike"]}스트라이크")
            return false
        }

        println("낫싱")
        return false
    }
}