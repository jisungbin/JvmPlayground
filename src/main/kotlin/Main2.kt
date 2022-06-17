fun main() {
    val data = mutableListOf(0).also(::plus)
    println(data)
}

fun plus(data: MutableList<Int>) {
    data.add(1)
    data + 2
}
