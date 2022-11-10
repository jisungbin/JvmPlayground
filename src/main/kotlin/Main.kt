fun main() {
}

interface Test {
    var data: Any
        get() = Class.forName("java.lang.String").newInstance()
        set(value) = TODO()

    companion object Test
}

fun Test.test() = one + 1
