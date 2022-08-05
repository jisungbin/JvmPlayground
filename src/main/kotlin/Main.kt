fun main() {
    val old = mutableListOf(1)
    val new = old.apply { add(2) }
    println(old == new)
}
