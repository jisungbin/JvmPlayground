

fun main() {
    println("1".hashCode())
    println("2".hashCode())
    println("3".hashCode())

    var value = 1
    val valueLambda = { println(value) }

    repeat(3) {
        println(valueLambda.hashCode())
        value++
    }
}
