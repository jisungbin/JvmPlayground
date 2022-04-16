import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(/*job*/) {
        delay(1000)
        println("Text 1")
    }
    launch(job) {
        delay(2000)
        println("Text 2")
    }
    job.cancel()
    println("Bye, world!")
}