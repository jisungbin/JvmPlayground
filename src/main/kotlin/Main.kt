class SynchronizeTest {

    data class Value(var int : Int)

    @Volatile
    var value: Value = Value(0)

    init {
        val thread1 = createReadWriteThread()
        val thread2 = createReadWriteThread()
        val thread3 = createReadWriteThread()

        thread1.start()
        thread2.start()
        thread3.start()

        thread1.join()
        thread2.join()
        thread3.join()
        println(value.int)
    }

    private fun createReadWriteThread(): Thread {
        return Thread {
            for (i in 0 until 1000) {
                value.int++
            }
        }
    }
}

fun main() {
    SynchronizeTest()
}

data class Value(var int: Int, var boolean: Boolean)