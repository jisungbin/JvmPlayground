import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

private fun CoroutineScope.makeChannel() = produce { println("Channel started")
    for (i in 1..3) {
        delay(1000)
        send(i) }
}

suspend fun main() = runBlocking {
    val l = product {
        repeat(3) {
            add("User$it")
            println("L: Added User")
        }
    }
    val l2 = l.map {
        println("L: Processing")
        "Processed $it"
    }
    val s = sequence {
        repeat(3) {
            yield("User$it")
            println("S: Added User")
        }
    }
    val s2 = s.map {
        println("S: Processing")
        "Processed $it"
    }
    println("s1: $l2")
    println("s2: $s2")
}