import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val one = getOne()
    val two = getTwo()
    println("one + two: ${one + two}")
}

suspend fun getOne(): Int {
    delay(1000)
    return 1
}

suspend fun getTwo(): Int {
    delay(1000)
    return 2
}