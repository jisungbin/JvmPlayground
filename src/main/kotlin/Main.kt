import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    launch {
        println("Slept 0 ms.")
    }
    println("Sleeping...")
}