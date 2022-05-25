fun main() {
    val string = "AA"
    val string2 = "AA"
    println(string === string2)
    println(string.intern())
    println(string2.intern())
}