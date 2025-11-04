package com.back.domain.wiseSaying

import com.back.TestRunner
import org.assertj.core.api.Assertions
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

        assertContains(out, "명언");
        assertContains(out, "작가");
    }

    @Test
    @DisplayName("명언 목록 테스트")
    fun t2(){
        val out = TestRunner.run("""
            등록
            현재를 사랑하라
            작자미상
            목록
        """.trimIndent())

        assertContains(out, "명언");
        assertContains(out, "작가");
        assertContains(out, "현재를 사랑하라");
        assertContains(out, "작자미상");
    }

    @Test
    @DisplayName("삭제?id=1 두번 요청에 대한 예외 처리")
    fun `명언 삭제`(){
        val out = TestRunner.run("""
            등록
            현재를 사랑하라.
            작자미상
            삭제?id=1
            삭제?id=1
        """.trimIndent())

        Assertions.assertThat(out)
            .contains("명언")
            .contains("작가")
            .contains("1번 명언이 삭제되었습니다")
            .contains("1번 명언은 존재하지 않습니다")
    }

    @Test
    @DisplayName("수정?id=1")
    fun t3(){
        val out = TestRunner.run("""
            등록
            현재를 사랑하라.
            작자미상
            수정?id=1
            과거에 집착하지 말라
            작자미상
            목록
        """.trimIndent())

        Assertions.assertThat(out)
            .contains("과거에 집착하지 말라")
            .contains("작자미상")
    }
}