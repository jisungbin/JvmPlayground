import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private val flow = MutableSharedFlow<Unit>(replay = 1)

fun main(): Unit = runBlocking {
  launch { combine(flow, flowOf(Unit)) { _, _ -> }.collect(::println) }
  makeRequest().getOrNull()?.let { flow.emit(it) }
}

private fun makeRequest() = Result.success(Unit)