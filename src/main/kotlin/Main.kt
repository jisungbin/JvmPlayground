fun test(action: () -> String) {
    print(action())
}

fun main() {
    test {
        "Bye, world!"
    }
}
