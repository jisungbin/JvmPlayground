val list = listOf(3, 1, 4, 2, 5, 6, 2)
const val targetIndex = 2 // 4

fun main() {
    list
        .withIndex()
        .sortedByDescending { (index, _) -> index == targetIndex }
        .map(IndexedValue<Int>::value)
        .let(::println)
}