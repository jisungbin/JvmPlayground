import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

fun main() {
  suspend { println("Hello, World!") }.startCoroutine(Continuation(EmptyCoroutineContext) { result ->
    result.getOrThrow()
  })
}
