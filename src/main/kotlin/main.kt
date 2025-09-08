private const val changedLowBitMask = 0b001_001_001_001_001_001_001_001_001_001_0

// 0b010_010_010_010_010_010_010_010_010_010_0
private const val changedHighBitMask = changedLowBitMask shl 1

private const val changedMask = (changedLowBitMask or changedHighBitMask).inv()

fun main() {
  println(Integer.toBinaryString(changedMask))
}