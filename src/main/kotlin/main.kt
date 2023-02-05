import kotlin.properties.Delegates

fun main() {
    lateinit var one: String
    var two by Delegates.notNull<String>()
}