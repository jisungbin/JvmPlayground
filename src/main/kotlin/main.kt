fun main() {
    val list = listOf(1, 2, 3, 4, 5)
    val filter = listOf(1, 2, 3, 4)
    println(list.dropWhile(filter::contains))
}