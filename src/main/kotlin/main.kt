@JvmInline
value class QuackPluginLocal(public val value: Any?)

fun main() {
    println(QuackPluginLocal(1) == QuackPluginLocal(2))
    println(QuackPluginLocal(1) == QuackPluginLocal(1))
}