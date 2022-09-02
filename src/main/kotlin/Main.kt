

val String.Companion.One get() = "1"

fun String.Companion.hi() {
    println("Hi")
}

fun main() {
    String.hi()
    println(String.One)
}