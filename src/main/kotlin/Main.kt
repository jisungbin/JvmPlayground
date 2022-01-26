import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {
    fun String.checkNiceUrl() = Patterns.WEB_URL.matcher(this).matches()
    val test = """
        test.test
        http://naver.com
        https://www.wwwmasd/a///asdrg#@R7f8uhisdfnjk`213refpv'da;lvxcsD12refdfafafewf
    """.trimIndent().split("\n")
    test.forEach {
        println("$it: ${it.checkNiceUrl()}")
    }
}