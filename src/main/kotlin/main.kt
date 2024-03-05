internal fun interface StableColorProducer {
  operator fun invoke(): Int
}

fun main() {
  println(StableColorProducer { 1 }())
}