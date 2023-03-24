@Suppress("CONFLICTING_PROJECTION", "VARIANCE_ON_TYPE_PARAMETER_NOT_ALLOWED")
inline fun <reified in T> printNumbers(numbers: List<in Int>): Class<T> {
    for (number in numbers) {
        println(number)
    }
    return T::class.java
}

val ints: List<Int> = listOf(1, 2, 3)
val anys: List<Any> = listOf("hello", 1, 2.0)

fun main() {
    printNumbers<Int>(ints)
    printNumbers<Int>(anys)
}