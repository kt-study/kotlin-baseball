package com.kotlinbaseball.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

internal class BaseballsTest : StringSpec({

    "임의의 서로 다른 Baseball 3개를 만든 후 저장한다." {
        // when
        val baseballs = Baseballs.init()

        // then
        baseballs.values shouldHaveSize 3
    }

    "입력된 값에 따라 Baseball 3개를 만든 후 저장한다." {
        // when
        val baseBalls = Baseballs.from("123")

        // then
        baseBalls.values shouldHaveSize 3
        baseBalls.values.shouldContainExactly(Baseball(1), Baseball(2), Baseball(3))
    }

    "입력된 값에 정수가 아닌 값이 포함된 경우 예외가 발생한다." {
        // given
        val errorCondition = "#"

        // when
        val exception = shouldThrow<IllegalArgumentException> { Baseballs.from("12$errorCondition") }

        // then
        exception.message shouldBe "입력된 문자 $errorCondition 는 정수가 아닙니다."
    }

    "입력된 값의 길이가 3이 아니면 예외가 발생한다." {
        // given
        val tooShortCondition = "12"
        val tooLongCondition = "1234"

        // when
        val shortException = shouldThrow<IllegalArgumentException> { Baseballs.from(tooShortCondition) }
        val longException = shouldThrow<IllegalArgumentException> { Baseballs.from(tooLongCondition) }

        // then
        shortException.message shouldBe "입력된 문자열의 길이 ${tooShortCondition.length} 가 ${Baseballs.BALL_COUNT} 와 다릅니다."
        longException.message shouldBe "입력된 문자열의 길이 ${tooLongCondition.length} 가 ${Baseballs.BALL_COUNT} 와 다릅니다."
    }

    "입력된 값에 중복된 정수가 포함된 경우 예외가 발생한다." {
        // given
        val duplicateCondition = "111"

        // when
        val duplicateException = shouldThrow<IllegalArgumentException> { Baseballs.from(duplicateCondition) }

        // then
        duplicateException.message shouldBe "중복된 숫자가 입력되었습니다."
    }
})
