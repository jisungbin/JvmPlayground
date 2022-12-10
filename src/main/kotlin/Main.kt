@file:Suppress("VARIABLE_WITH_REDUNDANT_INITIALIZER")

private fun test(
    totalItemsCount: Int,
    chunkedSize: Int = 3,
) {
    val a = (totalItemsCount % chunkedSize).let {
        if (it != 0) {
            3 - it
        } else it
    }
    println(a)
}

fun main() {
    test(30)
    test(31)
    test(32)
    test(33)
    test(34)
    test(35)
    test(36)
    test(37)
    test(38)
}