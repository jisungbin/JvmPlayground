fun main() {
  repeat(10) {
    if (it == 5) throw RuntimeException("it is 5")
    println(it)
  }
}