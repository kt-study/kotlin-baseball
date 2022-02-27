package com.kotlinbaseball.domain

data class Baseball(
    val number: Int
) {

    init {
        validateNegative(number)
    }

    private fun validateNegative(number: Int) {
        if (number < MIN_NUMBER || MAX_NUMBER < number) {
            throw IllegalArgumentException("$number 는 $MIN_NUMBER~$MAX_NUMBER 사이의 수가 아닙니다.")
        }
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 9
    }
}
