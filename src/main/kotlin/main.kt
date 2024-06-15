import okio.Buffer

fun main() {
  val buffer = Buffer()
  buffer.writeUtf8("Hello, World!").writeUtf8("\n")
  println(buffer[buffer.size - 1])
  println("\n".single().code)
}