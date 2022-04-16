fun main() {
    getSequence().forEach(::println)
}

fun getSequence(): Sequence<String> = sequence {
    repeat(3) {
//        delay(1000) // Compilation error
        yield("User$it")
    }
}
