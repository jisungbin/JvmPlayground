class World {
    val hello = "Hello, world!"
    fun bye() = "Bye, world!"
}

fun main() {
    val lambda = { println("Bye, world!") }
    val hello = World::hello
    val bye = World::bye
    println(hello)
    println(bye)
    lambda()
}
