import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.coroutines.suspendCoroutine


fun main() {
    thread(isDaemon = true) {
        Thread.sleep(1000L)
        println("World!")
        println("Thread (2): ${Thread.currentThread().name}")
    }
    thread(isDaemon = true) {
        Thread.sleep(1000L)
        println("World!")
        println("Thread (3): ${Thread.currentThread().name}")
    }
    thread(isDaemon = true) {
        Thread.sleep(1000L)
        println("World!")
        println("Thread (4): ${Thread.currentThread().name}")
    }
    println("Hello, ")
    println("Thread (1): ${Thread.currentThread().name}")
    Thread.sleep(2000L)
}
