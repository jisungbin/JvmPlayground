interface Test {
    fun sayHi()
}

object TestScope : Test {
    override fun sayHi() {
        println("Hi")
    }
}

@Target(AnnotationTarget.TYPE)
annotation class TestAnn