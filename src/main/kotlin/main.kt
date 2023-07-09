fun main() {
    val list = mutableListOf(1)
    val print = { println(list.joinToString()) }
    print()
    list.add(1)
    print()
}