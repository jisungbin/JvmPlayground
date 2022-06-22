fun main() {
    Data("11", 11, false).hashCode().also(::println)
    Data("11", 11, false).hashCode().also(::println)
    Data("11", 11, false).hashCode().also(::println)
}

data class Data(
    val name: String,
    val id: Int,
    val tf: Boolean
)
