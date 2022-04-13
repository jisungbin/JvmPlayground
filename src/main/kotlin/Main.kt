import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    delayOneSec()
    println("Bye, world!")
}

suspend inline fun delayOneSec() {
    delay(1000)
}