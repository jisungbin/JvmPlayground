fun Long.withFlag(flag: Boolean): ULong {
  val packed = toULong()
  val mask = 1UL shl 63
  return if (flag) packed or mask else packed and mask.inv()
}

fun ULong.unpackFlagged(): Pair<Boolean, ULong> {
  val mask = 1UL shl 63
  val flag = (this and mask) != 0UL
  val unpacked = this and (mask - 1UL)
  return flag to unpacked
}

fun main() {
  val value = Long.MAX_VALUE
  val trueed = value.withFlag(true)
  val falseed = value.withFlag(false)

  println("original: ${value.toString(2).padStart(64, '0')}")
  println("trueed  : ${trueed.toString(2).padStart(64, '0')}")
  println("falseed : ${falseed.toString(2).padStart(64, '0')}")

  val (flag1, unpacked1) = trueed.unpackFlagged()
  val (flag2, unpacked2) = falseed.unpackFlagged()

  println()

  println("original: $value")
  println("trueed  : flag=${flag1.toString().padStart(5)}, unpacked=$unpacked1")
  println("falseed : flag=${flag2.toString().padStart(5)}, unpacked=$unpacked2")
}
