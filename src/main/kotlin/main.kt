fun main() {
  val a = 0b1 shl 0
  val b = 0b1 shl 1
  val c = 0b1 shl 2

  println(a.toString(radix = 2))
  println(b.toString(radix = 2))
  println(c.toString(radix = 2))
  println()
  println((a or c).toString(radix = 2))
  println((c or a).toString(radix = 2))
}
