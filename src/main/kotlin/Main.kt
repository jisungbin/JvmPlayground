import java.io.File

fun main() {
    println("20221120 지성빈 스트림")
    File("/Users/jisungbin/Downloads/i-hate-java.txt").run {
        createNewFile()
        writeText("KOREA")
        println("from text: ${readText()}")
        println("from byte: ${readBytes().decodeToString()}")

        writeText(
            """
                더하기 a+b=15
                빼기 a-b=5
            """.trimIndent()
        )
        println("from text: ${readText()}")
        println("from byte: ${readBytes().decodeToString()}")

        delete()
    }
}
