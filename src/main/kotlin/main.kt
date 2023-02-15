fun main() {
    val list = mutableListOf(1)
    println(list === list.apply { add(2) })
}