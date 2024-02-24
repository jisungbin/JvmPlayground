const val a = 1 shl 0
const val b = 1 shl 1
const val c = 1 shl 2
const val d = 1 shl 3
const val e = 1 shl 4

fun main() {
  val abc = a or b or c

  println("""
    $a (${Integer.toBinaryString(a)})
    $b (${Integer.toBinaryString(b)})
    $c (${Integer.toBinaryString(c)})
    $d (${Integer.toBinaryString(d)})
    $e (${Integer.toBinaryString(e)})
    
    $abc (${Integer.toBinaryString(abc)})
    
    ${abc and a}
    ${abc and b}
    ${abc and c}
    ${abc and d}
    ${abc and e}
  """.trimIndent())
}