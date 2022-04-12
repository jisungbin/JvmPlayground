import kotlin.concurrent.thread

fun main() {
    repeat(100) {
        thread {
            Thread.sleep(1000L)
            print(".")
        }
    }
}