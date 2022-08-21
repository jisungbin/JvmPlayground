import java.io.File

fun main() {
    val rootFolderPath =
        "/Users/jisungbin/AndroidStudioProjects/duckie-quack-quack/ui-components/src/main/kotlin/team/duckie/quackquack/ui/constant"
    val rootFolder = File(rootFolderPath)
    rootFolder.list()!!.forEach { fileName ->
        println(fileName)
    }
    println()
    rootFolder.listFiles()!!.forEach { file ->
        println(file.toString())
    }
}
