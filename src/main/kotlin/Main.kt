sealed interface DuckApiResult<T>

class DuckApiException(override val message: String?) : Exception(), DuckApiResult<Nothing>

sealed class DuckFetchResult : DuckApiResult<Nothing> {
    data class Success<T>(val value: T) : DuckApiResult<T>
    object Empty : DuckApiResult<Nothing>
}

fun main() {
    val result: DuckApiResult<Nothing> = DuckApiException(null)
    println(
        when (result) {
            is DuckApiException -> "DuckApiException"
            is DuckFetchResult.Success -> "DuckFetchResult.Success: ${result.value}"
            is DuckFetchResult.Empty -> "DuckFetchResult.Empty"
        }
    )
}
