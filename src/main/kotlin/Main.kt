import kotlinx.coroutines.Job
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job = Job()
    println("Started.")
    launch(job) {
        try {
            awaitCancellation()
        } finally {
            println("Canceled.")
        }
    }
    delay(1000)
    println("Wait 1000 second and cancel job.")
    job.cancel()
}
