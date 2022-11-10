import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BaseViewModel<State, SideEffect>(
    initialState: State,
) {
    private val _state = MutableStateFlow(value = initialState)
    val state = _state.asStateFlow()

    private val _sideEffect = Channel<SideEffect>()
    val sideEffect = _sideEffect.receiveAsFlow()

    protected val currentState get() = _state.value

    protected fun updateState(
        reducer: State.() -> State,
    ) {
        val newState = currentState.reducer()
        _state.value = newState
    }

    protected suspend fun postSideEffect(
        effect: () -> SideEffect,
    ) {
        _sideEffect.send(element = effect())
    }
}