fun Long.withFlag(flag: Boolean): ULong {
  @Suppress("KotlinConstantConditions") // false-positive
  require(this >= 0) { "Only non-negative values are supported" }

  val packed = toULong()
  val mask = 1UL shl 63
  return if (flag) packed or mask else packed and mask.inv()
}

fun unpackFlagged(value: ULong): Pair<Boolean, Long> {
  val mask = 1UL shl 63
  val flag = (value and mask) != 0UL
  val unpacked = (value and (mask - 1UL)).toLong()
  return flag to unpacked
}

fun main() {
  val value = Long.MAX_VALUE
  val trueed = value.withFlag(true)
  val falseed = value.withFlag(false)

  println("original: ${value.toString(2).padStart(64, '0')}")
  println("trueed  : ${trueed.toString(2).padStart(64, '0')}")
  println("falseed : ${falseed.toString(2).padStart(64, '0')}")

  val (flag1, unpacked1) = unpackFlagged(trueed)
  val (flag2, unpacked2) = unpackFlagged(falseed)

  println()

  println("original: $value")
  println("trueed  : flag=${flag1.toString().padStart(5)}, unpacked=$unpacked1")
  println("falseed : flag=${flag2.toString().padStart(5)}, unpacked=$unpacked2")
}
