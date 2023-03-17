interface Hi

class HiImpl : Hi

fun sa() {}

class Test {
    var test: Int? = 1
    public fun AAAA(
        text: String? = "HI~~~",
        number: Int? = 1_231_111,
        hi: Hi? = HiImpl(),
    ) {
        test = number
    }

    init {
        AAAA()
    }
}

fun main() {
    val a = Class.forName("Test").getConstructor().newInstance()
    val b = a.javaClass

    b.getMethod(
        "AAAA\$default",
        b,
        java.lang.String::class.java,
        java.lang.Integer::class.java,
        Hi::class.java,
        Int::class.java,
        java.lang.Object::class.java,
    ).invoke(a, a, null, null, null, Int.MAX_VALUE, null)

    // println(b.getMethod("getTest").invoke(a))
    println("AAA".toMutableList().apply { addAll(1, "BBB".toList()) }.joinToString(""))
}