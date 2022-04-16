import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow

suspend fun main(): Unit = coroutineScope {
    getFlow().collect {
    }
}

fun getFlow() = flow {
    emit(1)
}