object Modifier

interface A {
    fun Modifier.a()
}

interface B {
    fun Modifier.b()
}

object AScope : A {
    override fun Modifier.a() {}
}

object BScope : B {
    override fun Modifier.b() {}
}

object Test : A by AScope, B by BScope

fun A.test() {
    Modifier.a()
}