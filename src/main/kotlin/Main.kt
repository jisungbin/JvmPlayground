import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.supervisorScope

/*
const val SUSPENDED = 1000

interface Continuation {
    var label: Int
    fun resume()
}

fun main() {
    val continuationImpl = object : Continuation {
        override var label = 0
        override fun resume() {
            label++
        }
    }
}

fun continueFunction(continuation: Continuation): Int {
    continuation.resume()
}*/

suspend fun main() {
    println("Value: ${getIntAsync().await()}")
}

suspend fun getIntAsync() = supervisorScope {
    delay(100)
    async {
        delay(100)
        1
    }
}