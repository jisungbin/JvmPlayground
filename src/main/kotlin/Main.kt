fun main() {
    val rawCode = """
        |// Kotlin
        |fun main() {
        |    println("Hello, Kotlin!")
        |}
    """.trimMargin()
    val codes = rawCode.split("\n").mapIndexed { index, code ->
        if (index == 0) {
            code
        } else {
            "   $code"
        }
    }
    println(codes.joinToString("\n"))
}