import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val flow = flow {
        repeat(100) {
            delay(1000)
            emit(it)
        }
    }
    // state flow, shared flow: hot
    // flow: cold
    delay(1000)
    flow.buffer().collect {
        delay(1000)
        println("collected: $it")
    }
}