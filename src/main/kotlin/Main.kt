import kotlin.concurrent.thread
import kotlinx.coroutines.coroutineScope

suspend fun main() = coroutineScope {
    thread {
        println("Start!")
        Thread.sleep(1000)
        println("Kotlin Coroutines World!")
    }
    println("Hello")
}