fun main() {
  println((0b1 shl 1) or (0b1 shl 2))
  println(((0b1 shl 1) or (0b1 shl 2)).toString(2))
  println((0b1 shl 0) or (0b1 shl 1) or (0b1 shl 2))
  println(((0b1 shl 0) or (0b1 shl 1) or (0b1 shl 2)).toString(2))
  println((0b1 shl 0) and ((0b1 shl 1) or (0b1 shl 2)))
  println(((0b1 shl 0) and ((0b1 shl 1) or (0b1 shl 2))).toString(2))
}