import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking {
    println(Thread.currentThread().name)
    withContext(Dispatchers.IO) {
        println(Thread.currentThread().name)
    }
}