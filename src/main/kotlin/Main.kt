class IntHolder(val int: Int)

data class IntHolders(
    val one: IntHolder,
    val two: IntHolder
)

fun main() {
    val one = IntHolders(IntHolder(1), IntHolder(2))
    val two = IntHolders(IntHolder(1), IntHolder(2))
    println(one == two)
}