fun main() {
    val test = CompositionLocalContext.Test
    test.javaClass.getDeclaredField("test").apply {
        isAccessible = true
        println(get(test))
    }
}