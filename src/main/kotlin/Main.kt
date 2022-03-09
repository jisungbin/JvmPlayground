import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val sharedFlow = MutableSharedFlow<Int>()
    val channel = Channel<Int>()
    launch {
        repeat(10) {
            emitting(it, sharedFlow, channel)
        }
    }
    launch {
        sharedFlow.collect { println("SharedFlow: $it") }
    }
    launch {
        channel.receiveAsFlow().collect { println("Channel: $it") }
    }
}

private suspend fun <T> emitting(
    value: T,
    flow: MutableSharedFlow<T>,
    channel: Channel<T>,
) {
    flow.emit(value)
    channel.send(value)
}