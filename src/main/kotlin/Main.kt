import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(/*job*/) {
        delay(1000)
        println("Text 1")
    }
    launch(job) {
        delay(2000)
        yield()
        println("Text 2")
    }
    job.cancel()
    job.invokeOnCompletion {  }
    println("Bye, world!")
}