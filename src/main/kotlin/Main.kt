import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun main(): Unit = runBlocking {
    try {
        coroutineScope {
            throw Exception("A!")
        }
    } catch (ignored: Exception) {
    }
    launch {
        println("B!")
    }
}