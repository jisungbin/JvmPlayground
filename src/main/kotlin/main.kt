fun main() {
  val function: () -> Unit = {}
  val a = function as Function1<Int, Unit>
  println(a.invoke(1))
}