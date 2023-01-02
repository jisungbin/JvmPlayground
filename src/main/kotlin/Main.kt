import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

internal class SavedStateFlowHelper<T>(
    private val savedStateHandle: MutableMap<String, StateFlow<T>>? = null,
    private val key: String? = null,
    initialValue: T,
) {
    private val savedState: StateFlow<T> = if (savedStateHandle != null && key != null) {
        savedStateHandle.getOrDefault(key, MutableStateFlow(initialValue))
    } else {
        MutableStateFlow(initialValue)
    }

    internal var value: T
        get() = savedState.value
        set(value) {
            if (savedStateHandle != null && key != null) {
                savedStateHandle[key] = MutableStateFlow(value)
            } else {
                (savedState as MutableStateFlow<T>).value = value
            }
        }

    fun asStateFlow() = savedState
}

fun main() = runBlocking {
    val counter = SavedStateFlowHelper(initialValue = 1)

    launch {
        counter.asStateFlow().collect {
            println(it)
        }
    }

    repeat(10) {
        delay(1000)
        counter.value += 1
    }
}