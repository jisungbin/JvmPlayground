import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main(): Unit = runBlocking {
    launch {
        delay(1000)
        println("1000 slept")
    }.also { job ->
        job.invokeOnCompletion {
            println("finished")
        }
    }
}