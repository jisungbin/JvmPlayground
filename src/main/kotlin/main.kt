sealed interface A

data object Test : A

fun main() {
  println(Test::class.objectInstance)
}
