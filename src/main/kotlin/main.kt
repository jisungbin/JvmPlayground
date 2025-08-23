class A {
  val a = println("1")

  init {
    println("2")
  }

  val b = println("3")

  init {
    println("4")
  }

  constructor() {
    println("0")
  }
}

fun main() {
  A()
}
