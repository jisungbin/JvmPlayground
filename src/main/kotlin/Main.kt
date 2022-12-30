enum class Test {
    A, B, C
}

fun main() {
    val test = enumValues<Test>()
    test.asList()
}