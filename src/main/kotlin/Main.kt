@file:Suppress("RedundantSuspendModifier")

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val scope = CoroutineScope(Dispatchers.Default)
    val scope2 = CoroutineScope(Dispatchers.Default)
    val scope3 = CoroutineScope(Dispatchers.Default)
    Thread.currentThread().name.also(::println)
    listOf(scope, scope2, scope3).forEach { eachScope ->
        eachScope.launch {
            println(Thread.currentThread().name)
        }
    }
}