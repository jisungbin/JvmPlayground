@JvmInline
value class QuackModifier(internal val data: QuackModifierData = QuackModifierData())

fun main() {
    val modifier = QuackModifier()
        .wrapContent()
        .fillContent()
}

fun QuackModifier.wrapContent() = also { data.height = 2 }
fun QuackModifier.fillContent() = also { data.height = 3 }

class QuackModifierData {
    var height = 1
}
