class A {
  override fun equals(other: Any?): Boolean = true
  override fun hashCode(): Int = 42
}

fun main() {
  println(A() == A())
  println(A() === A())
}
