@file:Suppress("OPT_IN_USAGE")

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    var number = 0
    runBlocking {
        val times = 10_000
        val worker1 = launch(Dispatchers.IO.limitedParallelism(1)) {
            repeat(times) { number++ }
        }
        val worker2 = launch(Dispatchers.IO.limitedParallelism(1)) {
            repeat(times) { number-- }
        }
        joinAll(worker1, worker2)
    }
    println(number)
}