import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val flow = MutableStateFlow(1)
    flow.collect {
        println(it)
    }
    flow.emitAll(flowOf(2, 3, 4, 5))
}