import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    launch {
        println("Slept 0 ms.")
    }
    launch {
        fakeCall()
    }
    println("Sleeping...")
}

suspend fun fakeCall(): Int {
    delay(100) // fake delay
    return 100
}