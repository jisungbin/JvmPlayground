@Suppress("UNCHECKED_CAST")
fun main() {
  val list = listOf(1, 2, 3, 4, 5).filter { it % 2 == 0 }
  (list as java.util.List<Int>).addAll(listOf(6, 7, 8, 9, 10))
  println(list)
}
