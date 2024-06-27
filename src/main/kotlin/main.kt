import okio.Buffer

fun main() {
  val buffer = Buffer().writeUtf8("AAA")
  println(buffer.readUtf8())
  println("2: " + buffer.readUtf8())
}