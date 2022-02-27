package com.kotlinbaseball.view

import com.kotlinbaseball.domain.BaseballGameScore

class OutputView {

    fun printInputNumbers() {
        print("숫자를 입력해주세요 : ")
    }

    fun printBaseballGameScore(score: BaseballGameScore) {
        if (score.getBallCount() == 0 && score.getStrikeCount() == 0) {
            println("낫싱")
        } else if (score.getBallCount() == 0) {
            println("${score.getStrikeCount()}스트라이크")
        } else if (score.getStrikeCount() == 0) {
            println("${score.getBallCount()}볼")
        } else {
            println("${score.getBallCount()}볼 ${score.getStrikeCount()}스트라이크")
        }
    }

    fun printEndOfGame() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    fun printAskPlayNewGame() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}
