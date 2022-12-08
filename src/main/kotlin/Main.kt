import kotlinx.coroutines.*

suspend fun main() {
    val job = Job()
    withContext(Dispatchers.Default + job) {
        repeat(100) {
            println(it)
            delay(1000)
        }
    }
    delay(5000)
    job.cancelAndJoin()
}