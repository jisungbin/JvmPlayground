abstract class Logger {
  abstract fun log(message: String)
}

class ConsoleLogger : Logger() {
  override fun log(message: String) = println(message)
}

context(logger: Logger) fun Int.doSomething() {
  logger.log("hello")
  // do something
  logger.log("bye")
  logger.log(": $this")
}

fun main() {
  with(1) {
    context(ConsoleLogger()) {
      doSomething()
    }
  }
} 
