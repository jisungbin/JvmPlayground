class A {
  override fun equals(other: Any?): Boolean = true
  override fun hashCode(): Int = 42
}

fun main() {
  println(A() == A())
  println(A() === A())
  println(1 == 1)
  println(123 === 1)
  println(123 === 123)
}
