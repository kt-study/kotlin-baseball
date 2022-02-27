package com.kotlinbaseball.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize

internal class BaseballsTest : StringSpec({

    "임의의 서로 다룬 Baseball 3개를 만든 후 저장한다" {
        // when
        val baseballs = Baseballs()

        // then
        baseballs.values shouldHaveSize 3
    }
})
