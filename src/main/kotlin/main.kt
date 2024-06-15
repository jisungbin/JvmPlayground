import java.io.File

fun main() {
  val target = File("/Users/jisungbin/AndroidStudioProjects/ComposeInvestigator")
  val calculation = {
    target.walkBottomUp()
      .filterNot { it.path.contains("build") }
      .filter { it.path.contains("src") }
  }

  calculation().forEach { file ->
    val message = { "Failed to rename file: ${file.path}" }
    when {
      file.name.contains("_tracking_") -> {
        check(file.renameTo(File(file.path.replace("_tracking_", "_tracing_"))), lazyMessage = message)
      }
      file.name.contains("Tracker") -> {
        check(file.renameTo(File(file.path.replace("Tracker", "Tracer"))), lazyMessage = message)
      }
      file.name.contains("Tracking") -> {
        check(file.renameTo(File(file.path.replace("Tracking", "Tracing"))), lazyMessage = message)
      }
      file.name.contains("TrackTable") -> {
        check(file.renameTo(File(file.path.replace("TrackTable", "TraceTable"))), lazyMessage = message)
      }
      file.name.contains("TrackLower") -> {
        check(file.renameTo(File(file.path.replace("TrackLower", "TraceLower"))), lazyMessage = message)
      }
      file.name.contains("tracktable") -> {
        check(file.renameTo(File(file.path.replace("tracktable", "tracetable"))), lazyMessage = message)
      }
    }
  }

  calculation().forEach { file ->
    if (file.name.contains("track", ignoreCase = true)) {
      println(file.path)
    }
  }
}