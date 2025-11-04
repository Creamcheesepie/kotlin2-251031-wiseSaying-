package com.back

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

object TestRunner {
    private val originalIn : InputStream = System.`in`;
    private val originalOut = System.out;

    fun run(input : String): String{
        System.setIn(
            ByteArrayInputStream(
                ("${input.trimIndent()}\n종료")
                    .toByteArray()
            )
        )

        val outputStream = ByteArrayOutputStream()
        val printStream  = PrintStream(outputStream)

        System.setOut(printStream);

        App().run();

        val result = outputStream
            .toString()
            .trim()
            .replace(Regex("\\r\\n"),"\\n") // 개행문자 표준화

        outputStream.close()
        printStream.close()

        //다시 표준 입력으로 복구
        System.setIn(originalIn);
        System.setOut(originalOut);


        return result;
    }
}