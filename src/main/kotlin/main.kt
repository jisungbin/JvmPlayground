interface A
interface B
interface C
interface D

interface R : A, B, C

fun main() {
    val r: R = object : R {}
    val rAsA = r as A
    println(rAsA::class.java.isAssignableFrom(D::class.java))
}
