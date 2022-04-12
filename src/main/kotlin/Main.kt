import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    awesomeSuspendFunction()
}

suspend fun awesomeSuspendFunction() {
    println("Hello, ")
    delay(1000)
    println("world!")
}