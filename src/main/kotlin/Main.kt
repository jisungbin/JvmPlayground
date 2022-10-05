import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking(
        context = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Caught $throwable in $coroutineContext")
        },
    ) {
        val job = launch(
            context = CoroutineExceptionHandler { coroutineContext, throwable ->
                println("Caught $throwable in $coroutineContext")
            },
        ) {
            delay(1000)
        }
        launch(
            context = CoroutineExceptionHandler { coroutineContext, throwable ->
                println("Caught $throwable in $coroutineContext")
            },
        ) {
            try {
                job.cancel()
                job.join()
            } catch (exception: Exception) {
                println("Caught $exception")
            }
        }
    }
}