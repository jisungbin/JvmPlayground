import okio.Buffer

fun main() {
  val buffer = Buffer().writeUtf8(('a'..'z').joinToString(separator = ""))
  buffer.readAndWriteUnsafe().use { cursor ->
    fun debug() {
      println("start: ${cursor.start}, offset: ${cursor.offset}, end: ${cursor.end}")
      println("content: ${cursor.buffer!!.snapshot().utf8()}")
      println()
    }

    cursor.seek(0)
    debug()

    cursor.seek(10)
    debug()

    cursor.seek(0)
    debug()

    cursor.seek(20)
    debug()

    repeat(3) {
      cursor.buffer!!.writeByte('_'.code)
    }
    debug()
  }
}
