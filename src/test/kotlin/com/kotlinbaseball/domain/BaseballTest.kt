package com.kotlinbaseball.domain

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class BaseballTest : StringSpec() {

    @DisplayName("Baseball의 값이 1에서 9 사이면 정상적으로 생성된다.")
    @ParameterizedTest
    @CsvSource("1", "3", "5", "9")
    fun validRangeValue(input: Int) {
        // when
        val baseball = Baseball(input)

        // then
        assertThat(baseball.number).isEqualTo(input)
    }

    @DisplayName("Baseball의 값이 1보다 작거나 9보다 크면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource("0", "10", "-1", "-9")
    fun invalidRangeValueException(input: Int) {
        // when, then
        assertThrows<IllegalArgumentException> {
            Baseball(input)
        }
    }
}
