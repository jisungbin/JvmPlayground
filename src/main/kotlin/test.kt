abstract class MyType<V : Any> {
  @Suppress("UNCHECKED_CAST")
  fun <K : Any> Map<K, *>.typedGet(k: K): V? =
    get(k) as? V

  data object Int : MyType<kotlin.Int>()
  data object String : MyType<kotlin.String>()
}

private fun test() {
  val maps = mapOf(1 to 2, 2 to "AA")
  val intType: Int? = with(MyType.Int) { maps.typedGet(1) }
  val stringType: String? = with(MyType.String) { maps.typedGet(2) }
}
