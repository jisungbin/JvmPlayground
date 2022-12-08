import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main(): Unit = runBlocking {
    val job = launch {
        delay(910)
        println("DONE!")
    }
    delay(900)
    job.cancelAndJoin()
    delay(100)
}