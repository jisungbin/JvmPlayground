class EmptyClass {
    override fun equals(other: Any?) = other is EmptyClass
    override fun hashCode() = javaClass.hashCode()
}

data class Int(val int: kotlin.Int)

class IntClass(val int: kotlin.Int)

fun main() {
    println(EmptyClass() == EmptyClass())
    println(Int(1) == Int(1))
    println(IntClass(1) == IntClass(1))
}
