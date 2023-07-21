annotation class Test
annotation class Test2(val value: String)

@[Test Test2("a") Deprecated("")]
fun test() {
}