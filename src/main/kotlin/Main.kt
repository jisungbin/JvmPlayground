import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
        println("0: " + Thread.currentThread().name)
    }
    GlobalScope.launch {
        delay(1000L)
        println("World!")
        println("1: " + Thread.currentThread().name)
    }
    GlobalScope.launch {
        delay(1000L)
        println("World!")
        println("2: " + Thread.currentThread().name)
    }
    println("Hello, ")
    println(Thread.currentThread().name)
    Thread.sleep(2000L)
}