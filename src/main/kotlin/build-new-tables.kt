@file:Suppress("NonAsciiCharacters")

import java.io.File

private const val rootPath = "/Users/jisungbin/IdeaProjects/jisungbin.github.io/java3"
private const val imagePath = "$rootPath/image"
private const val tablePath = "$rootPath/table"

fun main() {
    val images = (File(imagePath).list() ?: emptyArray()).map { image ->
        image.removeSuffix(".png")
    }.toSortedSet()
    val imageGroups = images.groupBy { image ->
        image.removeSuffix("_code").removeSuffix("_result")
    }
    val eachTableContents = imageGroups.map { (key, images) ->
        // 3-1_#1 -> 3주 1회차 #1
        val title = run {
            val 주 = key.split("-").first()
            val 회차 = key.split("-").last().split("_").first()
            val 번호 = key.split("#").last()
            "${주}주 ${회차}회차 #$번호"
        }
        // 3-1_#1 -> 3-1-1
        val tableFileName = key.replace("_#", "-")
        val tableContent = """
            |<!doctype html>
            |<html lang="ko">
            |<head>
            |    <meta charset="utf-8"/>
            |    <meta name="viewport" content="width=device-width,initial-sacle=1"/>
            |    <title>개인 과제 리스트</title>
            |</head>
            |<body>
            |<h2>$title</h2>
            |<h3>소스 코드</h3>
            |<img src="../image/${images.first().replace("#", "%23")}.png"/>
            |</body>
            |${
            if (images.size > 1) {
                """
                |<h3>실행 결과</h3>
                |<img src="../image/${images.last().replace("#", "%23")}.png"/>
                """.trimMargin()
            } else {
                ""
            }
        }
            |</html>
        """.trimMargin()
        tableFileName to tableContent.replace("</body>\n\n</html>", "</body>\n</html>")
    }

    val tableTables = eachTableContents.map { it.first }.groupBy { table ->
        val tableDatas = table.split("-")
        val 주 = tableDatas[0]
        val 회차 = tableDatas[1]
        "${주}주 ${회차}회차"
    }.map { (key, tables) ->
        """
        |<li>$key</li>
        |<ol>
        |${
            tables.joinToString("\n") { table ->
                """<li><a href="./table/${table}.html">${table.split("-").last()}번째 과제</a></li>"""
            }
        }
        |</ol>
        |<hr/>
        """.trimMargin()
    }.joinToString("\n")
    val readmeContent = """
        |<!doctype html>
        |<html lang="ko">
        |<head>
        |    <meta charset="utf-8"/>
        |    <meta name="viewport" content="width=device-width,initial-sacle=1"/>
        |    <title>개인 과제 리스트</title>
        |</head>
        |<body>
        |<h1>지성빈 과제 리스트</h1>
        |<ul>
        |<hr/>
        |$tableTables    
        |</ul>
        |</body>
        |</html>
    """.trimMargin()

    eachTableContents.forEach { (fileName, content) ->
        File("$tablePath/$fileName.html").also { file ->
            if (!file.parentFile.exists()) {
                file.parentFile.mkdirs()
            }
        }.writeText(content)
    }

    File("$rootPath/index.html").writeText(readmeContent)
}