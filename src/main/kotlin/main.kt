fun main() {
  val m = MyInterface::class.java.getMethod("method", String::class.java)
  val p = m.parameters[0]
  println(p.isNamePresent)
  println(p.name)
}

interface MyInterface {
  fun method(str: String?): String?
}
