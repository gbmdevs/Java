package utils

import java.io.File

object InputReader {
    fun readAsList(number: Int) = fileFromResources(number).readLines()

    private fun fileFromResources(number: Int): File {
        return File(javaClass.classLoader.getResource(
            "Day${number.toString().padStart(2, '0')}.txt")?.toURI()
            ?: error("Input for day $number not found!")
        )

    }

}