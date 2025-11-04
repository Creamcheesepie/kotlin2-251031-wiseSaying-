package com.back

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

object TestRunner {
    private val originalIn : InputStream = System.`in`;
    private val originalOut = System.out;

    fun run(input : String): String {
        System.setIn(
            ByteArrayInputStream(
                ("${input.trimIndent()}\n종료")
                    .toByteArray()
            )
        )

        return ByteArrayOutputStream().use { outputStream ->
            PrintStream(outputStream).use { printStream ->
                System.setOut(printStream);

                App().run();

                val result = outputStream
                    .toString()
                    .trim()
                    .replace(Regex("\\r\\n"), "\\n")
                result
            }
        }
    }
}