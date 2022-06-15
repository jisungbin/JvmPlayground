import Test.Object.VariableInObject

object Test {
    const val Variable = "Bye"

    object Object {
        const val VariableInObject = "World"
    }
}

// https://stackoverflow.com/questions/44455328/why-i-cannot-refer-to-a-nested-object-from-val-or-typealias-referring-to-an-obje
fun main() {
    with(Test) {
        listOf(
            Variable, VariableInObject
        )
    }
}
