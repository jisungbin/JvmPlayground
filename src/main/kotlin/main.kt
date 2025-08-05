import java.util.Collections.emptyList

@Suppress("UNCHECKED_CAST")
fun main() {
  println((emptyList<Any>() as java.util.List<Any>).add(1))
}