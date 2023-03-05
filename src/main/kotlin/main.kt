fun main() {
    test(
        modifier = Modifier
            .chain()
            .chain2()
            .chain3(),
    )
}

interface Modifier {
    companion object : Modifier
}

fun Modifier.chain() = this
fun Modifier.chain2() = this
fun Modifier.chain3() = this

fun test(modifier: Modifier) {}