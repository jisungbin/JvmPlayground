import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    val stateFlow = MutableStateFlow(0)
    val flow = stateFlow.asStateFlow()
    runBlocking {
        launch {
            repeat(100) {
                delay(1000)
                stateFlow.update { it + 1 }
            }
        }
        launch {
            flow.collect { value ->
                println("#1: $value")
            }
        }
        launch {
            flow.collect { value ->
                println("#2: $value")
            }
        }
        launch {
            flow.collect { value ->
                println("#3: $value")
            }
        }
    }
}