import com.squareup.wire.AnyMessage
import com.squareup.wire.Message
import com.squareup.wire.schema.EmptyWireLogger
import com.squareup.wire.schema.KotlinTarget
import com.squareup.wire.schema.Location
import com.squareup.wire.schema.WireRun
import component.RepeatingMessage
import component.TextComponent2
import okio.FileSystem

fun main() {
//  wireRun()

  val messages = RepeatingMessage(
    listOf(
      AnyMessage.pack(Message),
      AnyMessage.pack(TextComponent2("2")),
      AnyMessage.pack(TextComponent("3")),
    )
  )

  val bytes = RepeatingMessage.ADAPTER.encode(messages)
  val decoded = RepeatingMessage.ADAPTER.decode(bytes)

  decoded.messages.forEach { println(it.typeUrl) }
}

fun wireRun() {
  WireRun(
    sourcePath = listOf(Location.get("/Users/jisungbin/IdeaProjects/JvmPlayground/src/proto")),
    targets = listOf(
      KotlinTarget(outDirectory = "/Users/jisungbin/IdeaProjects/JvmPlayground/src/main/kotlin/proto", escapeKotlinKeywords = true),
    ),
  )
    .execute(FileSystem.SYSTEM, EmptyWireLogger())
}
