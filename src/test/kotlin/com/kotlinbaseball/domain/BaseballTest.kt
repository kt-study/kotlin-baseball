package com.kotlinbaseball.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.string.shouldEndWith

internal class BaseballTest : StringSpec({

    "Baseball의 값이 1에서 9 사이면 정상적으로 생성된다." {
        listOf(
            Baseball(1),
            Baseball(5),
            Baseball(9)
        ).forEach {
            it.number shouldBeGreaterThanOrEqual 1
            it.number shouldBeLessThanOrEqual 9
        }
    }

    "Baseball의 값이 1보다 작거나 9보다 크면 예외가 발생한다." {
        listOf<IllegalArgumentException>(
            shouldThrowExactly { Baseball(0) },
            shouldThrowExactly { Baseball(10) },
            shouldThrowExactly { Baseball(-1) },
            shouldThrowExactly { Baseball(-9) }
        ).forEach {
            it.message shouldEndWith "${Baseball.MIN_NUMBER}~${Baseball.MAX_NUMBER} 사이의 수가 아닙니다."
        }
    }
})
