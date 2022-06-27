import kotlinx.coroutines.Job
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job = Job()
    launch(job) {
        try {
            println("Await cancellation.")
            awaitCancellation()
        } finally {
            println("Cancelled.")
        }
    }
    launch {
        delay(1000)
        job.cancel()
        println("Cancel job after 1000 ms.")
    }
}
