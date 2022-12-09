@file:Suppress("VARIABLE_WITH_REDUNDANT_INITIALIZER")

import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun main() = runBlocking {
    val deferred = async {
        println("started - 1")
        delay(1000)
        println("Done - 1")
        1000
    }
    println("job1 status: ${deferred.isActive}")
    delay(400)
    deferred.cancelAndJoin()
    val result = runCatching {
        deferred.await()
    }
    println("job1 status: ${deferred.isActive}")
    println(result)
}