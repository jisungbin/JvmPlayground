import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    launch {
        delay(1000)
        println("1000 ms sleep.")
        println("Inner job: ${coroutineContext.job}")
    }
    println("start sleeping")
    println("Outer job: ${coroutineContext.job}")
    println("Outer job childrens: ${coroutineContext.job.children.joinToString(", ")}")
}
