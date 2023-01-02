@file:Suppress("OPT_IN_USAGE")

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    var number = 0
    val times = 10
    runBlocking {
        launch(Dispatchers.IO.limitedParallelism(1)) {
            repeat(times) { number++; println("++: $number") }
            //yield()
        }
        launch(Dispatchers.IO.limitedParallelism(1)) {
            repeat(times) { number--; println("--: $number") }
        }
    }
    println(number) // 0
}