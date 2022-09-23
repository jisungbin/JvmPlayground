import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


fun main() {
    CoroutineScope(context = Dispatchers.Default).launch {
        println("I was slept...!!")
    }
}