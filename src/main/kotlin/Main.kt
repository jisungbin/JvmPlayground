import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch { // non-suspend
        repeat(3) {
            println("first job: work ${it + 1}")
            // yield()
        }
    }

    launch {
        repeat(3) {
            println("second job: work ${it + 1}")
//            yield()
        }
    }

    repeat(3) {
        println("main: start job ${it + 1}")
//        yield()
    }
}