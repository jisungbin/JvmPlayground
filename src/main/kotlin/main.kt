import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
  val result: Any?
  runBlocking {
    result = withTimeoutOrNull(3.seconds) {
      repeat(1000) { i ->
        println("I'm sleeping $i ...")
        delay(500)
      }
    }
    println(result)
  }
}
