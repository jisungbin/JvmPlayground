
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.time.Duration
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    launch { suspendSort() }
    launch { suspendPrint(123) }
}

suspend fun suspendPrint(message: Any) {
    delay(Duration.ZERO)
    println(message)
}

suspend fun suspendSort(end: Int = 5_000_000_0): Unit = suspendCoroutine { continuation ->
    println("sort start")
    (1..end).sortedDescending()
    println("sort end")
    continuation.resume(Unit)
}