enum class A { B, C }
sealed class B {
    data class C(var a: Int = 1) : B()
    data class D(var a: Int = 1) : B()
}
object C

fun main() {
    println(B.C().hashCode())
    println(B.C().hashCode())
    println(B.C() == B.C())
    println(B.C() === B.C())
    println()
    println(C.hashCode())
    println(C.hashCode())
    println(C == C)
    println(C === C)
}