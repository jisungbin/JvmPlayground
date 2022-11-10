fun main() {
    val list = mutableListOf<Int>()
    test(
        value = run {
            println(1)
            list.add(1)
            1
        },
        value2 = run {
            list.add(2)
            println(list)
            2
        },
    )
}

fun test(
    value: Any,
    value2: Any,
) {
}