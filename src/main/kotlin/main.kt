private const val changedLowBitMask = 0b001_001_001_001_001_001_001_001_001_001_0
private const val changedHighBitMask = changedLowBitMask shl 1
private const val changedMask = (changedLowBitMask or changedHighBitMask).inv()

fun main() {
  println(changedLowBitMask.toString(2).padStart(31, '0'))
  println(changedHighBitMask.toString(2).padStart(31, '0'))
  println((changedLowBitMask or changedHighBitMask).toString(2).padStart(31, '0'))
  println(changedMask.toString(2).padStart(31, '0'))

  println("--------------------")

  val num = 0b0110110110110110110110110110110  // 31비트 수
  val result = num.inv()
  println(result.toString(2))  // -110110110110110110110110110111 (음수로 출력)
  println(Integer.toBinaryString(result))  // 비트 패턴 확인
}
