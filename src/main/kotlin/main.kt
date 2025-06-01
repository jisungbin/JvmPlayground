import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

fun main() {
  val job = Job()
  repeat(10) { count ->
    job.invokeOnCompletion { println(it) }
  }
  val scope = CoroutineScope(job)
  scope.cancel()
}