fun main() {
  val n = UInt.MAX_VALUE.toInt() and 0b1.inv()
  println(0b1.inv())
  println(Integer.toBinaryString(n).padStart(32, '_'))
  println(Integer.toBinaryString(n ushr 1).padStart(32, '_'))
}
