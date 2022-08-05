@file:Suppress("FunctionName")

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

open class PeopleWrapper(open val name: String, open val age: Int) {
    override fun toString() = "name: $name, age: $age"
}

class MutablePeopleImplWrapper(name: String, age: Int) : PeopleWrapper(name, age) {
    private val _name = MutableStateFlow(name)
    override var name
        get() = _name.value
        set(value) {
            _name.value = value
        }

    private val _age = MutableStateFlow(age)
    override var age
        get() = _age.value
        set(value) {
            _age.value = value
        }

    private val immutableImpl = object : StateFlow<PeopleWrapper> {
        override val replayCache: List<PeopleWrapper> get() = listOf(value)

        override val value
            get() = PeopleWrapper(
                name = _name.value,
                age = _age.value
            )

        override suspend fun collect(collector: FlowCollector<PeopleWrapper>): Nothing = coroutineScope {
            combine(_name, _age) { params ->
                PeopleWrapper(
                    name = params[0] as String,
                    age = params[1] as Int
                )
            }.stateIn(this).collect(collector)
        }
    }

    fun asStateFlow() = immutableImpl
}

fun People(name: String, age: Int) = MutablePeopleImplWrapper(name, age)

suspend fun main() {
    val people = People("Ji", 1)
    people.apply {
        name = "SungBin"
        age = 21
    }
    people.asStateFlow().collect {
        println("Collect: $it")
    }
}
