import java.io.File
import java.util.Locale

private const val QuackIconsPath =
    "/Users/jisungbin/AndroidStudioProjects/duckie-quack-quack/ui-components/src/main/res/drawable"
private val quackIcons = File(QuackIconsPath).list()!!.mapNotNull { filename ->
    filename.removeSuffix(".xml").takeIf { filename.endsWith(".xml") }
}

/*@Stable
val Search = QuackIcon(
    drawableId = R.drawable.ic_search_24,
)*/

private val camelRegex = "(?<=[a-zA-Z])[A-Z]".toRegex()
private val snakeRegex = "_[a-zA-Z]".toRegex()

fun String.snakeToLowerCamelCase() = snakeRegex.replace(this) {
    it.value.replace("_", "").uppercase()
}

fun String.snakeToUpperCamelCase() = snakeToLowerCamelCase().replaceFirstChar {
    if (it.isLowerCase()) {
        it.titlecase(Locale.getDefault())
    } else {
        it.toString()
    }
}

fun main() {
    println(quackIcons.joinToString("\n\n") { iconFileName ->
        val iconName = iconFileName.substringAfter("_").substringBeforeLast("_").snakeToUpperCamelCase()
        """
        |@Stable
        |val $iconName = QuackIcon(
        |    drawableId = R.drawable.$iconFileName,
        |)
        """.trimMargin()
    })
}