package com.kotlinbaseball.domain

import kotlin.random.Random

class Baseballs private constructor(
    val values: Set<Baseball>
) {
    fun compare(otherBaseballs: Baseballs): BaseballGameScore {
        val baseballGameScore = BaseballGameScore()

        for (i: Int in values.indices) {
            val baseball = values.elementAt(i)
            val otherBaseball = otherBaseballs.values.elementAt(i)

            compareBallAndStrike(baseball, otherBaseball, otherBaseballs, baseballGameScore)
        }

        return baseballGameScore
    }

    private fun compareBallAndStrike(
        baseball: Baseball,
        otherBaseball: Baseball,
        otherBaseballs: Baseballs,
        baseballGameScore: BaseballGameScore
    ) {
        if (baseball == otherBaseball) {
            baseballGameScore.increaseStrike()
            return
        }

        if (otherBaseballs.values.contains(baseball)) {
            baseballGameScore.increaseBall()
        }
    }

    companion object {
        const val BALL_COUNT: Int = 3

        fun init(): Baseballs {
            val values = mutableSetOf<Int>()

            while (values.size < BALL_COUNT) {
                values.add(Random.nextInt(Baseball.MIN_NUMBER, Baseball.MAX_NUMBER))
            }

            return Baseballs(
                values.map { Baseball(it) }
                    .toSet()
            )
        }

        fun from(string: String): Baseballs {
            validateLength(string)
            validateDigits(string)

            val values = setOf(string[0], string[1], string[2])
                .map { Baseball(it.digitToInt()) }
                .toSet()

            validateDuplicate(values)

            return Baseballs(values)
        }

        private fun validateDigits(string: String) {
            string.toCharArray().forEach { validateDigit(it) }
        }

        private fun validateDigit(character: Char) {
            if (!character.isDigit()) {
                throw IllegalArgumentException("입력된 문자 $character 는 정수가 아닙니다.")
            }
        }

        private fun validateLength(string: String) {
            if (string.length != BALL_COUNT) {
                throw IllegalArgumentException("입력된 문자열의 길이 ${string.length} 가 $BALL_COUNT 와 다릅니다.")
            }
        }

        private fun validateDuplicate(values: Set<Baseball>) {
            if (values.size != BALL_COUNT) {
                throw IllegalArgumentException("중복된 숫자가 입력되었습니다.")
            }
        }
    }
}
