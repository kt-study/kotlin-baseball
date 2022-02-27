package com.kotlinbaseball.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class BaseballGameScoreTest : StringSpec({

    "스트라이크가 3개가 되었는지 아닌지를 알 수 있다." {
        // given
        val baseballGameScore = BaseballGameScore()
        baseballGameScore.increaseStrike()
        baseballGameScore.increaseStrike()

        // when
        baseballGameScore.isNotThreeStrike() shouldBe true
        baseballGameScore.increaseStrike()

        // then
        baseballGameScore.isNotThreeStrike() shouldBe false
    }
})
