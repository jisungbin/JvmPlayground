@Target(
    AnnotationTarget.PROPERTY,
)
@RequiresOptIn(
    message = "이 필드는 MVP 개발 환경에서는 사용되서는 안됩니다.",
)
annotation class Unsupported

data class Test(
    @Unsupported val test: Int,
)