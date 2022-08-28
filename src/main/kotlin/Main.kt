@file:Suppress("UNCHECKED_CAST")

class Test {
    val list = listOf("1")
}

fun main() {
    val testClass = Class.forName("Test")
    val test = testClass.getDeclaredConstructor().newInstance()
    val getList = testClass.getDeclaredMethod("getList")
    val list = getList(test) as List<String>
    println(list)
}