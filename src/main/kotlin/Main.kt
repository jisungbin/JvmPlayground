
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main(): Unit = runBlocking {
    launch {
        supervisorScope {
            val worker = async { error("test") }
            val result = runCatching { worker.await() }
            println(result)
        }
    }
}