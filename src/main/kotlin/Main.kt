
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    launch {
        println("1")
        throw Exception()
    }
    launch {
        println("2")
        throw Exception()
    }
    launch {
        println("3")
        throw Exception()
    }
}