import com.caoccao.javet.interop.V8Host
import com.caoccao.javet.interop.V8Runtime

fun main() {
  val code = """
    |let num = 0
    |
    |function test() {
    |  return ++num
    |}
  """.trimMargin()

  val runtime = V8Host.getV8Instance().createV8Runtime<V8Runtime>()

  runtime.getExecutor(code).executeVoid()
  println(runtime.getExecutor("test()").executeString())
  println(runtime.getExecutor("test()").executeString())
  println(runtime.getExecutor("test()").executeString())
}