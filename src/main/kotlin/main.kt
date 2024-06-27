fun main() {
  val ints = IntArray(10) { 1 }
  println(ints[0]++)
  println(ints[0])
  println(++ints[0])
}
