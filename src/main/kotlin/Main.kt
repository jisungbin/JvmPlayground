@file:Suppress("RedundantSuspendModifier")

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    launch {
        println("Inner job: " + coroutineContext.job)
        delay(1000)
        println("1000 ms sleep.")
    }
    println("Outer job: " + coroutineContext.job)
    println("Outer job children: " + coroutineContext.job.children.toList())
    println("Hey, ")
}