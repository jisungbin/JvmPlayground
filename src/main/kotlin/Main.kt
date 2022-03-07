import kotlin.system.measureTimeMillis
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val runningTime = measureTimeMillis {
        val jobs = List(5) { index ->
            suspend {
                println("$index job start.")
                delay((index * 1000).toLong())
                println("$index job finish.")
            }
        }
        awaitAll(jobs)
    }
    println(runningTime)
}

private suspend fun awaitAll(jobs: List<suspend () -> Unit>) = coroutineScope {
    jobs.forEach { job ->
        launch {
            job()
        }
    }
}