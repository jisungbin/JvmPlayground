import kotlin.concurrent.thread

class StringPrinter {
    private var value: String? = null

    fun delayedPrint(name: String, delay: Int = 1000) {
        value = name
        sleep(delay)
        println(value)
    }
}

class LocalStringPrinter {
    private val value = ThreadLocal<String>()

    fun delayedPrint(name: String, delay: Int = 1000) {
        value.set(name)
        sleep(delay)
        println(value.get())
    }
}

fun main() {
    val stringPrinter = StringPrinter()
    thread { stringPrinter.delayedPrint("threadA") }
    thread { stringPrinter.delayedPrint("threadB") }

    println()

    val localStringPrinter = LocalStringPrinter()
    thread { localStringPrinter.delayedPrint("localThreadA") }
    thread { localStringPrinter.delayedPrint("localThreadB") }
}

private fun sleep(millis: Int) {
    try {
        Thread.sleep(millis.toLong())
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
}