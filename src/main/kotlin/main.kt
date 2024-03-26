fun main() = runBlocking {
  val channel = Channel<Unit>()

  launch {
    channel.consumeEach {
      println("Get: $it")
    }
  }

  repeat(5) {
    delay(300)
    channel.send(Uni)
  }
}