package com.back

import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertContains

class AppTest {

    @Test
    @DisplayName("~기념비적인 코틀린 첫번째 테스트 코드~")
    fun t1(){
        val out = TestRunner.run("""
            등록
            현재를 사랑하라
            작자미상
        """.trimIndent())

        assertContains(out,"명언");
        assertContains(out,"작가");
    }
}