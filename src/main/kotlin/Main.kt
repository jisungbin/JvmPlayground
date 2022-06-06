import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn

fun main() {
    val flow = MutableSharedFlow<Boolean>().shareIn(
        started = SharingStarted.WhileSubscribed(3000),
        scope = CoroutineScope(Dispatchers.Default)
    )
}
