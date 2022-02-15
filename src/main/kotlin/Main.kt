import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val flow = flow {
        repeat(100) {
            delay(300)
            emit(it)
        }
    }.stateIn(this)
    // state flow: hot
    // flow: cold
    delay(1000)
    flow.collect {
        println("collected: $it")
    }
}