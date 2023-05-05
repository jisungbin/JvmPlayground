fun test() {
    println(Thread.currentThread().stackTrace[1].methodName)
    println(object : Any() {}.javaClass.enclosingMethod.name)
}

fun main() {
    test()
}