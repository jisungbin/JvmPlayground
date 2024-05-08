import kotlin.concurrent.thread

val lock = Any()
var doneTime: Long? = null

fun lockAction() {
  synchronized(lock) {
    if (doneTime != null) return println("Done at $doneTime")
    Thread.sleep(3000)
    doneTime = System.currentTimeMillis()
    println("DONE! at $doneTime")
  }
}

fun main() {
  repeat(10) {
    thread { lockAction() }
  }
}
