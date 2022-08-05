data class Wrapper(val a: Int, val b: String)

fun main() {
    println(Wrapper(1, "1") == Wrapper(2, "1"))
}
