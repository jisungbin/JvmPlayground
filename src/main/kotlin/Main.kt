import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val sharedFlow = MutableSharedFlow<Int>()
    val channel = Channel<Int>()
    emitting(sharedFlow, channel)
    sharedFlow.collect { println(it) }
    channel.receiveAsFlow().collect { println(it) }
}

private suspend fun emitting(flow: MutableSharedFlow<Int>, channel: Channel<Int>) {
    flow.emit(1)
    channel.send(1)
}