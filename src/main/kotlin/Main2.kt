import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private data class Student(val column: Int, val row: Int, val friends: List<Int>)

fun main(): Unit = runBlocking {
    val test = CoroutineScope(Dispatchers.Default).launch {
        throw Exception("ERROR!")
    }
    test.start()
    // test.await()
}