import kotlin.reflect.full.declaredMemberProperties

class A private constructor(val a: Int) {
    companion object {
        operator fun invoke(a: Int): A {
            return A(a)
        }
    }
}

fun main() {
  val a = A(1)
  println(A::class.declaredMemberProperties)
}
