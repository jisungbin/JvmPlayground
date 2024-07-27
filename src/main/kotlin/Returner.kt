import com.caoccao.javet.annotations.V8Allow
import com.caoccao.javet.annotations.V8Convert
import com.caoccao.javet.annotations.V8Function
import com.caoccao.javet.enums.V8ConversionMode
import com.caoccao.javet.enums.V8ProxyMode

@V8Convert(mode = V8ConversionMode.AllowOnly, proxyMode = V8ProxyMode.Class)
class Returner {
  @V8Allow @V8Function
  fun process(value: Int): Int = value
}