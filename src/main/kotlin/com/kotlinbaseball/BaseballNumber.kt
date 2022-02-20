package com.kotlinbaseball

class BaseballNumber (
    val number: String
){

    companion object {
        fun of(): BaseballNumber {

            val range = 1..9
            var digit = 0
            var number = StringBuilder()

            while(digit < 3) {
                val num = range.random()

                if (!number.contains(num.toString())) {
                    number.append(num)
                    digit++
                }
            }

            validate(number.toString())

            return BaseballNumber(number.toString())
        }

        fun of(number: String?): BaseballNumber {
            validate(number)
            return BaseballNumber(number!!)
        }

        private fun validate(number: String?) {

            if (number == null) {
                throw IllegalArgumentException()
            }

            if (number.length != 3) {
                throw IllegalArgumentException()
            }

            for (num in number) {
                if (num < '0' || num > '9') {
                    throw IllegalArgumentException()
                }
            }
        }
    }

    fun checkBaseballNumber(inputBaseballNumber: BaseballNumber): Map<String, Int>{

        val result = hashMapOf("nothing" to 0, "ball" to 0, "strike" to 0)

        for (i in 0..number.length-1 step(1)) {
            val strikeOrBall =
                checkStrikeOrBall(i, number[i].toString(), inputBaseballNumber.number)
            result[strikeOrBall] = result[strikeOrBall]!! + 1
        }

        return result
    }

    private fun checkStrikeOrBall(index: Int, num: String, inputBaseballNumber: String): String {
        if (inputBaseballNumber[index].toString() == num) {
            return "strike"
        }

        if (inputBaseballNumber.contains(num)) {
            return "ball"
        }

        return "nothing"
    }
}