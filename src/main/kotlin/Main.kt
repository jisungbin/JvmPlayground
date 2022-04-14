import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    var i = 0
    while (i < 10) {
        try {
            println(i)
            if (++i > 5) return
        } catch (ignored: Exception) {

        }
    }
    println("while finished.")
}