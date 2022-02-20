package com.kotlinbaseball

class Baseball(
    private val computer: Computer
) {

    fun start() {
        println("게임이 시작되었습니다!")
        computer.initNumber()
    }

    fun play() {
        while (true) {
            print("숫자를 입력해주세요 : ")
            val inputBaseballNumber = BaseballNumber.of(readLine())

            if (computer.checkBaseballNumber(inputBaseballNumber)) {
                return
            }
        }
    }
}
