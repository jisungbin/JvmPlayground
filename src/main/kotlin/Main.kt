import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    awesomeSuspendFunction()
}

suspend fun awesomeSuspendFunction() {
    println("Hello, ")
    var int = 1
    delay(1000)
    int++
    println("world!, int is $int")
}