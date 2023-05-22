fun test(value: (() -> Unit) -> Unit) {
  value {
    print(1)
  }
}

fun main() {
  test { it() }
}