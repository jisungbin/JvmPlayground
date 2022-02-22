data class People(
    val firstName: String = "",
    val lastName: String = ""
) {
    val isNameStartWithJ = firstName.startsWith("J")
}

fun main() {
    val people = People()
    println(people.copy(firstName = "Ji", lastName = "Sungbin").isNameStartWithJ)
}