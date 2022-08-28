@file:Suppress("UNCHECKED_CAST")

object Test {
    val list = listOf("1")
}

fun main() {
    val testClass = Class.forName("Test")
    val test = testClass.getDeclaredConstructor().newInstance()
    val field = test.javaClass.getDeclaredField("list").apply {
        isAccessible = true
    }
    val list = field.get(test) as List<String>
    println(list)
}