import com.caoccao.javet.interop.V8Host
import com.caoccao.javet.interop.V8Runtime
import com.caoccao.javet.interop.converters.JavetProxyConverter
import com.caoccao.javet.values.reference.V8ValueFunction

fun main() {
  val code = """
    |function test(returner) {
    |  return returner.process(10);
    |}
  """.trimMargin()

  val runtime = V8Host.getV8Instance().createV8Runtime<V8Runtime>()
  runtime.converter = JavetProxyConverter()

  val param = runtime.createV8ValueObject().also { obj ->
    obj.bind(Returner())
  }

  runtime.getExecutor(code).compileV8Script().executeVoid()
  println(runtime.getExecutor("test").execute<V8ValueFunction>().callInteger(runtime.globalObject, param))
}