import okio.FileSystem
import okio.Path.Companion.toPath
import okio.buffer

fun main() {
  FileSystem.SYSTEM
    .openReadWrite("/Users/jisungbin/IdeaProjects/JvmPlayground/src/main/kotlin/TEST.txt".toPath(), mustExist = true)
    .use { fs ->
      val current = fs.source().buffer().use { it.readUtf8LineStrict() }
      fs.resize(0L)
      fs.sink().buffer().use { sink ->
        sink.writeUtf8(current)
        sink.writeUtf8("\n")
        sink.writeUtf8("Bye, World!")
      }
    }
}
