open class Parent(open val name: String = "1")
interface IParent {
    val name: String
}

class Child : IParent, Parent("1") {
    // 'name' in 'Parent' is final and cannot be overridden
    override val name = "2"
}

fun main() {
    val child = Child()
    println(child.name)
}