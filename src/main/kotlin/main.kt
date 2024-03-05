@JvmInline
value class W(val v: Any)

fun main() {
  println(W(1).hashCode())
  println(W(1).hashCode())
  println(W(124422).hashCode())
  println(W(124422).hashCode())
}