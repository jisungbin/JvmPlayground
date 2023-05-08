fun test(hi: String.() -> Int, bye: Unit.(hi: Int) -> String) {
    "".hi()
    bye(Unit, 1)
}

fun rawTest(hi: Function1<String, Int>, bye: Function2<Unit, Int, String>) {
    test(hi = hi, bye = bye)
}

fun rawTest2(hi: (String) -> Int, bye: Function2<Unit, Int, String>) {
    test(hi = hi, bye = bye)
}

fun main() {
    rawTest(
        hi = { v ->
            println(v)
            2
        },
        bye = { a, b ->
            println(a)
            b.toString()
        }
    )
}
