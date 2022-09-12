fun main() {
    gugudan(
        print = ::println,
        finish = { println("Finish GuGuDan!") }
    )
}

private fun gugudan(
    print: (guguResult: String) -> Unit,
    finish: () -> Unit,
) {
    repeat(9) {
        val guguResult = "${it + 1} * 2 = ${2 * (it + 1)}"
        print(guguResult) // callback
    }
    finish() // cps
}