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

fun main() {
    val sungbin = Sungbin(DroidKnights())
    sungbin.say()
}