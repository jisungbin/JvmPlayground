import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    launch {
        delay(1000)
        println("Slept 1000 ms.")
    }
    launch {
        delay(300)
        println("Slept 300 ms.")
    }
    println("sleeping...")
}