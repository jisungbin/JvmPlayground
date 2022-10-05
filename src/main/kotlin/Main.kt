import kotlinx.coroutines.*

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
            context = Dispatchers.IO,
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