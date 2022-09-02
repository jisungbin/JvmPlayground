import java.util.UUID

val String.Companion.One get() = "1"

fun String.Companion.hi() {
    println("Hi")
}

fun main() {
    println(UUID.randomUUID().toString())
    // 4b4ac8fe-9c2b-4675-bef1-3143d3b3f3d5
}