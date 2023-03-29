fun interface Runnable {
    fun run()
}

fun main() {
    val runnable = Runnable { println("HI") }
}