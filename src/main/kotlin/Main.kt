import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

suspend fun main() {
    flow { emit(1) }.stateIn(
        CoroutineScope(context = Dispatchers.Default),
        started = SharingStarted.WhileSubscribed(),
        initialValue = 1
    )
}
