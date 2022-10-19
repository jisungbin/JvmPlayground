@RequiresOptIn(
    message = "This API is experimental and may change in the future.",
)
@Target(
    AnnotationTarget.PROPERTY,
    AnnotationTarget.CONSTRUCTOR,
)
annotation class Unsupported

data class Test(
    @Unsupported val new: Int,
    val old: Int,
)

fun main() {
    val test = Test(
        new = 1,
        old = 1
    )
    test.new
}