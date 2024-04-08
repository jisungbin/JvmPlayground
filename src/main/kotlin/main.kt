@file:Suppress("KotlinConstantConditions")

fun main() {
  val a = Any()
  if (a is String) println(a.length)
  println((a as? Int)?.plus(1))
}