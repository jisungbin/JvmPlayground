@file:Suppress("ConstPropertyName")

import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val Debug = false

val dateFormatter = SimpleDateFormat("yyyy. M. dd. aa h:mm", Locale.KOREA)

fun main() {
    val targetFile = File("/Users/jisungbin/Downloads/chat/katalk.txt")
    val targetLines = targetFile.readLines()
    val targrtWholeText = targetFile.readText()

    val reportFile = File("/Users/jisungbin/Downloads/chat/report.txt").also {
        if (it.exists()) it.delete()
    }
    val errorFile = File("/Users/jisungbin/Downloads/chat/error.txt").also {
        if (it.exists()) it.delete()
    }

    val chats = mutableMapOf<String, MutableList<Pair<Date, String>>>()
    val errors = mutableListOf<String>()
    val leaveCheckResult = mutableMapOf<String, Boolean>()

    targetLines.forEach { line ->
        try {
            val dateString = line.split(",")[0]
            val name = line.split(", ")[1].split(" :")[0]
            val message = line.split(" : ")[1]
            val date = dateFormatter.parse(dateString)
            // if (leaveCheckResult[name] == null) {
            //     leaveCheckResult[name] =
            //         targrtWholeText.contains("${name}님을 내보냈습니다") || targrtWholeText.contains("${name}님이 나갔습니다")
            // }
            @Suppress("ConstantConditionIf")
            if (true) {
                chats.compute(name) { _, chats ->
                    val value = date to message
                    chats?.apply { add(value) } ?: mutableListOf(value)
                }
            }
        } catch (error: Exception) {
            if (!errorFile.exists()) {
                errorFile.createNewFile()
            }
            errors.add(
                """
                    |error: ${error.message}
                    |line: $line
                """.trimMargin()
            )
        }
    }
    errorFile.writeText(errors.joinToString("\n\n"))
    if (!Debug) {
        val result = buildList {
            chats.forEach { (name, messages) ->
                add(
                    """
                    name: $name
                    last message: ${messages.last().second}
                    last time: ${messages.last().first.let { dateFormatter.format(it) }}
                    message count: ${messages.size}
                    """.trimIndent() to messages.last().first
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