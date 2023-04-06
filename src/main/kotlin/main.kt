class StringPrinter {
    private var value: String? = null

    fun delayedPrint(name: String, delay: Int = 1000) {
        value = name
        sleep(delay)
        println(value)
    }
}

class LocalStringPrinter {
    private var value = ThreadLocal<String>()

    fun delayedPrint(name: String, delay: Int = 1000) {
        value.set(name)
        sleep(delay)
        println(value.get())
    }
}


private val stringPrinter = StringPrinter()
private val localStringPrinter = LocalStringPrinter()

fun main() {
    val threadA = Thread { stringPrinter.delayedPrint("threadA") }
    val threadB = Thread { stringPrinter.delayedPrint("threadB") }
    threadA.start()
    sleep(100)
    threadB.start()

    sleep(1500)
    println()

    val localThreadA = Thread { localStringPrinter.delayedPrint("localThreadA") }
    val localThreadB = Thread { localStringPrinter.delayedPrint("localThreadB") }
    localThreadA.start()
    sleep(100)
    localThreadB.start()

    sleep(1500)
}

@Suppress("NOTHING_TO_INLINE")
private inline fun sleep(millis: Int) {
    try {
        Thread.sleep(millis.toLong())
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
}