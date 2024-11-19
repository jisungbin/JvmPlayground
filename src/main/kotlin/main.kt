import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
  val channel = Channel<Unit>(onBufferOverflow = BufferOverflow.DROP_OLDEST)

  launch {
    repeat(10) {
      delay(1000L)
      channel.trySend(Unit)
    }
  }

  channel.consumeEach { println(it) }
}
