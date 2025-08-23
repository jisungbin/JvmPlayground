class A {
  init {
    println("4")
  }

  val a = println("1")

  val b = println("3")

  init {
    println("2")
  }

  constructor() {
    println("0")
  }
}

fun main() {
  A()
}
