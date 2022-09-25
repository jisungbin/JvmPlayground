@RequiresOptIn(
    message = "TEST",
)
annotation class TestOptIn

@TestOptIn
private const val One = 1

@OptIn(TestOptIn::class)
fun getOne() = One

fun main() {
    print(getOne())
}