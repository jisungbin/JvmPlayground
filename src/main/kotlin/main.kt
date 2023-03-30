fun interface A {
    fun plus(num: Int, num2: Int)
}

fun main() {
    val a = Plus<Int> { num, num2 ->
        println(num + num2)
    }
    a.plus(1, 1)
}