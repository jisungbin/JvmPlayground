fun main() {
  println(Long.MAX_VALUE.toString(radix = 2))
  println((Int.MAX_VALUE.toLong() shl 32).toString(radix = 2))
  println(1234.toLong().toString(radix = 2).padStart(63))
  println(1234.toLong().shl(32).toString(radix = 2).padStart(63))
  println(0xFFFFFFFF.toString(radix = 2).padStart(63))
  println(5678.toLong().toString(radix = 2).padStart(63))
  println((5678.toLong() and 0xFFFFFFFF).toString(radix = 2).padStart(63))
  println((1234.toLong().shl(32) or (5678.toLong() and 0xFFFFFFFF)).toString(radix = 2).padStart(63))
}
