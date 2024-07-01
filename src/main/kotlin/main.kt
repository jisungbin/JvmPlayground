private const val NodeBit_Mask = 0b0100_0000_0000_0000__0000_0000_0000_0000
private const val ObjectKey_Mask = 0b0010_0000_0000_0000__0000_0000_0000_0000
private const val ObjectKey_Shift = 29
private const val Aux_Mask = 0b0001_0000_0000_0000__0000_0000_0000_0000
private const val Aux_Shift = 28
private const val Mark_Mask = 0b0000_1000_0000_0000__0000_0000_0000_0000
private const val ContainsMark_Mask = 0b0000_0100_0000_0000__0000_0000_0000_0000
private const val Slots_Shift = Aux_Shift
private const val NodeCount_Mask = 0b0000_0011_1111_1111__1111_1111_1111_1111

fun main() {
  println(NodeBit_Mask)
  println(ObjectKey_Mask)
  println(ObjectKey_Shift)
  println(Aux_Mask)
  println(Aux_Shift)
  println(Mark_Mask)
  println(ContainsMark_Mask)
  println(Slots_Shift)
  println(NodeCount_Mask)
  println(Int.MAX_VALUE)
}
