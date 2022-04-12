import kotlin.concurrent.thread

val seq = sequence {
    println("Generating first")
    yield(1)
    println("Generating second")
    yield(2)
    println("Generating third")
    yield(3)
    println("Done")
}.toList().also(::println)

fun main() {
    seq
}