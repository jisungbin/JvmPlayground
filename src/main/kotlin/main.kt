fun main() {
  println(mutableMapOf(1 to 1).hashCode())
  println(mutableMapOf(1 to 1).hashCode())
  println(mutableMapOf(1 to 2).hashCode())
  println(mutableMapOf(1 to 2).hashCode())
  println(mutableMapOf(1 to 1, 1 to 2).hashCode())
  println(mutableMapOf(1 to 1, 1 to 2).hashCode())
}