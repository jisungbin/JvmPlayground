@file:Suppress("RedundantSuspendModifier")

suspend fun main() {
    val name = getName()
    val age = getAge()
    println("$name, $age")
}

suspend fun getName() = "Ji Sungbin"

suspend fun getAge() = 21