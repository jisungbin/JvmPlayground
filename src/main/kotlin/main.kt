import okio.Buffer
import okio.ByteString.Companion.encodeUtf8

fun main() {
  val buffer = Buffer()
  buffer.writeUtf8("""
    |object Numbers {
    |  const val ONE = 1
    |  const val TWO = 2
    |}
  """.trimMargin())

  println(buffer.peek().readUtf8())
  println()

  val oneOffset = buffer.indexOfElement("Numbers".encodeUtf8())
  buffer.skip(oneOffset)

  println("oneOffset is $oneOffset")
  println(buffer.peek().readUtf8())
  println()

  val newOne = "ONE = 1_000".encodeUtf8()
  buffer.write(newOne)

  println(buffer.readUtf8())
}
