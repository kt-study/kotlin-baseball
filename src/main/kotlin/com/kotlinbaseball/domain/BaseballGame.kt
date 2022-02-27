package com.kotlinbaseball.domain

import com.kotlinbaseball.view.InputView
import com.kotlinbaseball.view.OutputView
import java.lang.IllegalArgumentException

private const val YES = "1"
private const val NO = "2"

class BaseballGame(
    private val computerBaseballs: Baseballs = Baseballs.init(),
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {
    fun play() {
        do {
            outputView.printInputNumbers()

            val playerBaseballs = Baseballs.from(inputView.inputNumbers())
            val score = computerBaseballs.compare(playerBaseballs)

            outputView.printBaseballGameScore(score)
        } while (score.isNotThreeStrike())

        outputView.printEndOfGame()
    }

    fun playerWantNewGame(): Boolean {
        outputView.printAskPlayNewGame()
        val wantPlayNewGame = inputView.inputWantPlayNewGame()

        if (wantPlayNewGame != YES && wantPlayNewGame != NO) {
            throw IllegalArgumentException("게임을 새로시작하기 위한 입력 $wantPlayNewGame 는 유효하지 않습니다.")
        }

        return wantPlayNewGame == YES
    }
}
