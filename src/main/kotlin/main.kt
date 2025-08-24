class A {
  constructor() {
    println("0")
  }

  val a = println("1")

  init {
    println("2")
  }

  val b = println("3")

  init {
    println("4")
  }
}

fun main() {
  A()
}
