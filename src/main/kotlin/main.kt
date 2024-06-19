enum class MarkdownToken {
  Text,
  Number;

  override fun toString(): String = "${javaClass.name}.${name}"
}

fun main() {
  println(MarkdownToken.Text)
  println(MarkdownToken.Number)
}
