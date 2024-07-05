@file:Suppress("UNUSED_VARIABLE")

import org.intellij.lang.annotations.Language

fun main() {
  // language=kotlin
  val kotlinCode = """
    fun main() {
      println("Hello~")
    }
  """.trimIndent()

  @Language("kotlin")
  val kotlinCode2 = """
    fun main() {
      println("Hello~2")
    }
  """.trimIndent()
}

