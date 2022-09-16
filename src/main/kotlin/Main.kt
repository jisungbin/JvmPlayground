import kotlinx.coroutines.delay

suspend fun main() {
    println(getDelayedValue(1000, 1))
}

private suspend fun <T> getDelayedValue(
    delay: Long,
    value: T,
): T {
    delay(delay)
    return value
}