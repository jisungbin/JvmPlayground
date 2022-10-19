sealed interface DuckApiResult<T> {
    data class Exception<T>(val message: String?) : DuckApiResult<T>
}

sealed class DuckFetchResult<T> : DuckApiResult<T> {
    data class Success<T>(val value: T) : DuckFetchResult<T>()
    class Empty<T> : DuckFetchResult<T>()
}

sealed class DuckUpsertResult<T> : DuckApiResult<T> {
    class Done<T> : DuckUpsertResult<T>()
}

fun main() {
    val exception: DuckApiResult<Int> = DuckApiResult.Exception("11")
    val success: DuckApiResult<Int> = DuckFetchResult.Success(1)
    println(
        when (exception) {
            is DuckApiResult.Exception -> "DuckApiException: ${exception.message}"
            is DuckFetchResult.Success -> "DuckFetchResult.Success: ${exception.value}"
            is DuckFetchResult.Empty -> "DuckFetchResult.Empty"
            is DuckUpsertResult.Done -> "DuckUpsertResult.Done"
        }
    )
}
