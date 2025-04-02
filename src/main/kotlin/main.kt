import abc.Testaaa

/** AAA */
enum class M {
  A,
  B,

  /**
   *  bbb
   *
   * @sample myawesome.hello
   **/
  C
}

object ASDAD : Testaaa

fun hexStringToArgb(hex: String): Int {
  // "0x" 또는 "#"이 있다면 제거
  val cleanedHex = hex.removePrefix("0x").removePrefix("#")

  // ARGB 값을 Int로 변환
  return cleanedHex.toLong(16).toInt()
}

fun main() {
  val hexColor = "0xFFFAFAFA"
  val argb = hexStringToArgb(hexColor)

  val alpha = (argb shr 24) and 0xFF
  val red = (argb shr 16) and 0xFF
  val green = (argb shr 8) and 0xFF
  val blue = argb and 0xFF

  println("ARGB: ($alpha, $red, $green, $blue)")
}