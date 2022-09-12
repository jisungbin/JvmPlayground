import kotlin.coroutines.Continuation
import kotlinx.coroutines.Dispatchers

fun main() {
    val cc = Continuation<Int>(Dispatchers.Default) {
        println("Hello, World!: ${it.getOrNull()}")
    }
    // cc.resume(1)
}