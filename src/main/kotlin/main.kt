import kotlin.math.pow

fun main() {
  println(Integer.toBinaryString(1).padStart(32, '0'))
  println(Integer.toBinaryString(-1).padStart(32, '0'))
  println(1.toString(radix = 2))
  println((-1).toString(radix = 2))
  println(2.0.pow(32).toUInt().toString(radix = 2).padStart(32, '0'))
  println(UInt.MAX_VALUE.toString(radix = 2).padStart(32, '0'))
}