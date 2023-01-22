@file:Suppress("ForEachParameterNotUsed")

import java.text.DecimalFormat
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.system.measureNanoTime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    val times = List(100_000) {}
    val decimal = DecimalFormat("#,###")

    launch {
        var average = 0L
        launch {
            repeat(10) { fastCount ->
                launch(Dispatchers.IO) {
                    average += measureNanoTime {
                        var value = 0
                        times.fastForEach {
                            value++
                        }
                    }.also { result ->
                        println("[$fastCount] Collections Fast API: ${result}ns")
                    }
                }
            }
        }.join()
        println("[AVERAGE] Collections Fast API: ${decimal.format(average / 10)}ns")
    }

    launch {
        var average = 0L
        launch {
            repeat(10) { normalCount ->
                launch(Dispatchers.IO) {
                    average += measureNanoTime {
                        var value = 0
                        times.forEach {
                            value++
                        }
                    }.also { result ->
                        println("[$normalCount] Collections Normal API: ${result}ns")
                    }
                }
            }
        }.join()
        println("[AVERAGE] Collections Normal API: ${decimal.format(average / 10)}ns")
    }

    Unit
}

@Suppress("BanInlineOptIn")
@OptIn(ExperimentalContracts::class)
inline fun <T> List<T>.fastForEach(action: (T) -> Unit) {
    contract { callsInPlace(action) }
    for (index in indices) {
        val item = get(index)
        action(item)
    }
}