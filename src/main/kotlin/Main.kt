import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        delay(300)
        println("3")
    }
    launch {
        delay(100)
        println("2")
    }
    println("1")
}