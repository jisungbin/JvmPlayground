import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main() = runBlocking {
    val coroutine = MyCustomCoroutineContextWithoutJob(Dispatchers.Default).launch {
        delay(3000)
        println("Delayed 3000 ms.")
    }
    coroutine.cancelAndJoin()
    delay(4000)
    println("Coroutine completed.")
}

class MyCustomCoroutineContextWithoutJob(override val coroutineContext: CoroutineContext) : CoroutineScope