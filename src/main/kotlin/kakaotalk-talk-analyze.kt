@file:Suppress("ConstPropertyName")

import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val Debug = false

fun main() {
    val targetFile = File("/Users/jisungbin/Downloads/chat/katalk.txt")
    val targetLines = targetFile.readLines()
    val targrtWholeText = targetFile.readText()

    val reportFile = File("/Users/jisungbin/Downloads/chat/report.txt")
    val errorFile = File("/Users/jisungbin/Downloads/chat/error.txt")

    val chats = mutableMapOf<String, List<Pair<Date, String>>>()
    val leaveCheckResult = mutableMapOf<String, Boolean>()

    val dateFormatter = SimpleDateFormat("YYYY. M. dd. aa h:mm", Locale.KOREA)

    targetLines.forEach { line ->
        try {
            val dateString = line.split(",")[0]
            val name = line.split(", ")[1].split(" :")[0]
            val message = line.split(" : ")[1]
            val date = dateFormatter.parse(dateString)
            if (leaveCheckResult[name] == null) {
                leaveCheckResult[name] =
                    targrtWholeText.contains("${name}님을 내보냈습니다") || targrtWholeText.contains("${name}님이 나갔습니다")
            }
            if (!leaveCheckResult[name]!!) {
                if (chats[name] == null) {
                    chats[name] = listOf(Pair(date, message))
                } else {
                    chats[name] = chats[name]!! + Pair(date, message)
                }
            }
        } catch (error: Exception) {
            if (!errorFile.exists()) {
                errorFile.createNewFile()
            }
            errorFile.appendText(
                """
                    |
                    |
                    |error: ${error.message}
                    |line: $line
                """.trimMargin()
            )
        }
    }
    if (!Debug) {
        val result = buildList {
            chats.forEach { (name, messages) ->
                add(
                    """
                name: $name
                last message: ${messages.last().second}
                last time: ${messages.last().first.let { dateFormatter.format(it) }}
                message count: ${messages.size}
                """.trimIndent()
                            to
                            messages.last().first
                )
            }
        }
        result.sortedBy { it.second }.let { report ->
            if (!reportFile.exists()) {
                reportFile.createNewFile()
            }
            reportFile.writeText(report.joinToString("\n\n") { it.first })
        }
    }
}