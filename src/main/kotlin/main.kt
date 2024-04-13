import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.buildCodeBlock

fun main() {
  val function = FunSpec.builder("name").addStatement("return 1").build()
  val codeBlock = buildCodeBlock { add("%L", function) }
  println(codeBlock)
}
