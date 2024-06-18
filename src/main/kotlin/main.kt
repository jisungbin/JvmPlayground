import okio.Buffer

private const val UPPER_CASE_OFFSET = ('A'.code - 'a'.code).toByte()

fun main() {
  val buffer = Buffer().apply {
    val chars = ('a'..'z').toList()
    val charSize = chars.size
    repeat(8192) {
      repeat(charSize) { index ->
        writeByte(chars[index].code)
      }
    }
  }
  buffer.readAndWriteUnsafe().use { cursor ->

    do {
      // println("current is ${cursor.data!![cursor.start]} and result is ${cursor.data!![cursor.start].uppercase()}")
      // cursor.data!![cursor.start] = cursor.data!![cursor.start].uppercase()
      println(
        """
        start: ${cursor.start}
        end: ${cursor.end}
        offset: ${cursor.offset}
        """.trimIndent()
      )
      println()
    } while (cursor.next() != -1)
  }
//  println(buffer.readUtf8())
}

fun Byte.uppercase(): Byte {
  if (this < 'a'.code.toByte() || this > 'z'.code.toByte()) return this
  return (this + UPPER_CASE_OFFSET).toByte()
}
