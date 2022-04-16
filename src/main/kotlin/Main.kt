import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext

suspend fun main() = supervisorScope {
    // withContext(CoroutineExceptionHandler { _, throwable -> println("Exception: $throwable") }) {
    val str1 = async<String> {
        delay(1000)
        throw Exception()
    }
    val str2 = async {
        delay(2000)
        "Text2"
    }
    try {
        println(str1.await())
    } catch (e: Exception) {
        println(e)
    }
    println(str2.await())
}