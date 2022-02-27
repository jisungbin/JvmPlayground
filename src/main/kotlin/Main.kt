internal class Test2 {

    @Volatile    // volatile 을 붙임으로써 데이터 불일치를 해결할 수 있다.
    var value: Value = Value(0, false)

    init {
        val read = createReadThread()
        val write = createWriteThread()
        read.start()
        Thread.sleep(1000)
        write.start()

        read.join()
        write.join()

    }

    private fun createReadThread(): Thread {
        return Thread {
            while (value.int < 9 && !value.boolean) {
            }
            println("read thread finish")
        }
    }

    private fun createWriteThread(): Thread {
        return Thread {
            for (i in 0 until 10) {
                value.int++
            }
            value.boolean = true
            println("write thread finish")
        }
    }

}

fun main() {
    Test2()
}

data class Value(var int: Int, var boolean: Boolean)