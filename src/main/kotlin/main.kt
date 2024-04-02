import java.util.concurrent.CompletableFuture

internal class SharedResource {
  private var state = 0

  fun increase() {
    state++
  }

  fun decrease() {
    state--
  }

  fun initialize() {
    state = 0
  }

  val isCorrupted: Boolean
    get() = this.state != 0
}

fun main() {
  var corruptedStateCount = 0
  val sharedResource = SharedResource()
  for (index in 0..99999) {
    sharedResource.initialize()
    val thread1 = CompletableFuture.runAsync {
      for (subIndex in 0..99) {
        sharedResource.increase()
      }
    }
    val thread2 = CompletableFuture.runAsync {
      for (subIndex in 0..99) {
        sharedResource.decrease()
      }
    }
    thread1.join()
    thread2.join()
    if (sharedResource.isCorrupted) {
      corruptedStateCount++
    }
  }
  println(String.format("Corrupted shared resource count - %s", corruptedStateCount))
}
