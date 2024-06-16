import okio.Buffer

fun main() {
  val buffer = Buffer().writeUtf8("hello")
  println(buffer.snapshot().utf8())
  buffer.readAndWriteUnsafe().use { cursor ->
    val previousSize = cursor.resizeBuffer(buffer.size + 4)
    cursor.seek(0)
    cursor.data!!.copyInto(
      destination = cursor.data!!,
      destinationOffset = 2,
      startIndex = cursor.start,
      endIndex = previousSize.toInt(),
    )
    cursor.data!![cursor.start] = 'a'.code.toByte()
    cursor.data!![cursor.start + 1] = 'b'.code.toByte()
    cursor.seek(cursor.buffer!!.size - 2)
    cursor.data!![cursor.start] = 'c'.code.toByte()
    cursor.data!![cursor.start + 1] = 'd'.code.toByte()
  }
  println(buffer.readUtf8())
}
