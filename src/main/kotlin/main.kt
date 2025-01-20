import kotlin.time.measureTime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  measureTime {
    runBlocking {
      CoroutineScope(Dispatchers.Default.limitedParallelism(1)).launch {
        repeat(5) {
          launch {
            println(Thread.currentThread().name)
            Thread.sleep(1000)
          }
        }
      }
        .join()
    }
  }
    .also { println("Time: $it") }
}