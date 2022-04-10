fun test(action: (index: Int) -> Unit) {
    print(action(1))
}

fun main() {
    test { itt: In\
        t ->
        print(itt)
    }
}
