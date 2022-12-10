
import kotlinx.coroutines.async
import kotlinx.coroutines.supervisorScope

suspend fun main() {
    try {
        supervisorScope {
            val worker = async { error("test") }
            val result = runCatching { worker.await() }
            println(result)
        }
    } catch (exception: Exception) {
        println(exception)
    }
}