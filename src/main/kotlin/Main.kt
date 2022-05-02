fun returnNothing(): Nothing {
    println(1)
    throw Exception()
}

fun main() {
    returnNothing()
    println(1)
}