fun main() {
  val container = 0b1 shl 3
  val zero = 0b1 shl 0
  val a = 0b1 shl 1
  val b = 0b1 shl 5

  println(container.toString(radix = 2))
  println(zero.toString(radix = 2))
  println(a.toString(radix = 2))
  println(b.toString(radix = 2))

  println()

  println((a or b).toString(radix = 2))
  println(((a or b) or container).toString(radix = 2))
  println((((a or b) or container) or a).toString(radix = 2))
  println(((((a or b) or container) or a) or zero).toString(radix = 2))
}
