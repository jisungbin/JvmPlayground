interface Modifier {
    companion object : Modifier
}

fun Modifier.test() = this
fun Modifier.test2() = this

fun main() {
    val modifier = Modifier.test().test2()
    modifierFun(modifier)
}

fun modifierFun(modifier: Modifier) {}