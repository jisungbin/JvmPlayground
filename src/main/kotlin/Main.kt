
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(): Unit = runBlocking {
    val job = Job().apply {
        invokeOnCompletion {
            println("Job completion!!")
        }
    }
    withContext(job) {
        println("Bye, world!")
    }
    job.cancel()
}
