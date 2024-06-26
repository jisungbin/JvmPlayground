import okio.FileSystem
import okio.Path.Companion.toPath
import okio.buffer

fun main() {
  FileSystem.SYSTEM
    .openReadWrite("/Users/jisungbin/IdeaProjects/JvmPlayground/src/main/kotlin/TestFile.txt".toPath())
    .use { fs ->
      val source = fs.source().buffer()
      val sink = fs.sink().buffer()

      while (!source.exhausted()) {
        val line = source.readUtf8LineStrict()
        if (line == "Hello, World!") {
          sink.writeUtf8("Bye, World!")
          sink.writeUtf8("\n")
          break
        }
        sink.writeUtf8(line)
        sink.writeUtf8("\n")
      }

      source.close()
      sink.close()
    }
}
