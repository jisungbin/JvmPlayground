import kotlin.reflect.KProperty

interface Speaker {
    val subject: String
    val script: String
    fun say()
}

class DroidKnights : Speaker {
    override val subject = "Jetpack Compose 내부 작동 원리"
    override val script = """
        안녕하세요, 저는 $subject 에 대해 발표할 지성빈 입니다.
        Jetpack Compose 는 작년 7월달에 stable 로 출시되었습니다.
        ...
    """.trimIndent()

    override fun say() {
        println("[$subject] $script")
    }
}

class Sungbin(private val presentation: Speaker) : Speaker {
    override val subject = presentation.subject
    override val script = presentation.script
    override fun say() {
        presentation.say()
    }
}

class SungbinBy(presentation: Speaker) : Speaker by presentation

class CustomString {
    private var value = ""

    operator fun getValue(ref: Any?, prop: KProperty<*>) = "[CustomString] $value"

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        this.value = value
    }
}

val nameMap = mutableMapOf(
    "first" to "Ji", "second" to "Sung", "last" to "bin"
)

class NameBy {
    var first by nameMap
    var second by nameMap
    var last by nameMap
    fun print() {
        println(listOf(first, second, last))
    }
}

fun main() {
    val sungbin = SungbinBy(DroidKnights())
    sungbin.say()

    val nameBy = NameBy()
    nameBy.print()

    var customString by CustomString()
    customString = "Bye, world."
    println(customString)
}