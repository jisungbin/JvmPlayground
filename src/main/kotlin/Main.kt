import java.io.BufferedReader
import java.io.FileReader

fun sequenceOfLines(fileName: String) = sequence {
    BufferedReader(FileReader(fileName)).use {
        while (true) {
            yield(it.readLine() ?: break)
        }
    }
}

fun main() {
    sequenceOfLines("https://github.com/kotlin/kotlin-coroutines-examples/tree/master/examples/sequence/sequenceOfLines.kt")
        .forEach(::println)
}