
import com.squareup.wire.schema.Location
import com.squareup.wire.schema.SchemaLoader
import okio.FileSystem

fun main() {
  val root = Location.get("scheme")
  val loader = SchemaLoader(FileSystem.SYSTEM)
  loader.initRoots(listOf(root), listOf(root))

  val widget = loader.load("widget/v1/widget.proto")
  println(widget)
}