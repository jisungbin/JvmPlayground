import kotlin.reflect.full.createInstance

class A {
    val a = 1
}

fun main() {
    println(A::class.createInstance().a)
}