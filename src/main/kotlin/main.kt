fun main() {
  val UPPER_CASE_OFFSET = ('A'.code - 'a'.code).toByte()
  val LOWER_CASE_OFFSET = ('a'.code - 'A'.code).toByte()

  fun Byte.uppercase(): Byte {
    if (this < 'a'.code.toByte() || this > 'z'.code.toByte()) return this
    return (this + UPPER_CASE_OFFSET).toByte()
  }

  fun Byte.lowercase(): Byte {
    if (this < 'A'.code.toByte() || this > 'Z'.code.toByte()) return this
    return (this + LOWER_CASE_OFFSET).toByte()
  }

  for (char in 'a'..'z') {
    println(char.code.toByte().uppercase().toInt().toChar())
  }

  for (char in 'A'..'Z') {
    println(char.code.toByte().lowercase().toInt().toChar())
  }
}
