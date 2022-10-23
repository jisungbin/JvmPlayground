interface A {
    val a: Int
}

interface B : A {
    override val a: Int
    val b: Int
}

fun main() {
    val B = object : B {
        override val a = 1
        override val b = 2
    }
    val A = B as A
    println(B.a)
    println(A.a)
    println((A as B).b)
}