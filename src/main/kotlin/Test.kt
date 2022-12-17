class CompositionLocalContext private constructor(
    private val test: String,
) {
    companion object {
        val Test = CompositionLocalContext("T")
    }
}
