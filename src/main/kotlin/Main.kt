import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

private val _flow = MutableStateFlow(1)
val flow: StateFlow<Int> get() = _flow
val flow2 = _flow.asStateFlow()
