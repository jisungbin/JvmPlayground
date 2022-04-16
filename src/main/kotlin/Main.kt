import kotlin.system.measureTimeMillis
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main(): Unit = coroutineScope {
    launch {
        printCoroutinesTime(Dispatchers.IO) // 2,000 ms
    }
    launch {
        val dispatcher = Dispatchers.IO.limitedParallelism(1000) // or 10
        printCoroutinesTime(dispatcher) // 1,000 ms or 10,000 ms
    }
}

@Suppress("BlockingMethodInNonBlockingContext")
suspend fun printCoroutinesTime(
    dispatcher: CoroutineDispatcher
) {
    val test = measureTimeMillis {
        coroutineScope {
            repeat(100) {
                launch(dispatcher) {
                    Thread.sleep(1000)
                    println("Current worker: ${Thread.currentThread().name} for $dispatcher")
                }
            }
        }
    }
    println("$dispatcher took: $test")
}