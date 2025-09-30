import kotlin.reflect.full.functions

class A(private val a: Int) {
  fun p(b: Any) = a.toString() + b
}

fun main() {
  val a = A(1)
  println(a::class.functions.first { it.name == "p" }.call(a, 2))
}
