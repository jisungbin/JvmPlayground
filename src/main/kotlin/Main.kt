import kotlin.time.ExperimentalTime
import kotlin.time.measureTime
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalTime::class)
fun main(): Unit = runBlocking {
    val time = measureTime {
        val one = async {
            delay(1000)
            1
        }
        val two = async {
            delay(1000)
            2
        }
        println(one.await() + two.await())
    }
    println(time)
}