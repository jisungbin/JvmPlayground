import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main(): Unit = coroutineScope {
    produce {
        repeat(100) { value ->
            delay(500)
            send(value)
        }
    }.also { channel ->
        repeat(3) { index ->
            launch {
                for (value in channel) {
                    println("Receive value in $index coroutine: $value")
                }
            }
        }
    }
}
