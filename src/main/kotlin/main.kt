import okio.FileSystem
import okio.Path.Companion.toPath

fun main() {
  val file = "/Users/jisungbin/IdeaProjects/JvmPlayground/src/main/kotlin/test.txt".toPath()
  FileSystem.SYSTEM.write(file) { writeUtf8("Bye!") }
}