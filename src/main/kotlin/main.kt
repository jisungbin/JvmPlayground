import java.io.File

fun main() {
  val target = File("/Users/jisungbin/AndroidStudioProjects/ComposeInvestigator")
  target.walkBottomUp().forEach { file ->
    if (file.name.contains("track")) {
      println(file.absolutePath)
    }
  }
}