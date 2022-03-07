import kotlin.system.measureTimeMillis
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine

fun main() = runBlocking {
    val runningTime = measureTimeMillis {
        val jobs = List(5) { index ->
            suspend {
                println("$index job start.")
                delay((index * 1000).toLong())
                "$index job finished at ${System.currentTimeMillis()}"
            }
        }
        awaitAll(jobs).forEach(::println)
    }
    println("measureTime: $runningTime")
}

private suspend fun <T> awaitAll(jobs: List<suspend () -> T>) = coroutineScope {
    jobs.map { job ->
        suspendCancellableCoroutine<T> {
            launch {
                job()
            }
        }
    }
}