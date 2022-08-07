@file:Suppress("MayBeConstant")

// 컴파일 전
val NonCaptureLambda = { println("bye, world!") }

// 컴파일 후
class NonCaptureLambda : Function0<Unit> {
    override fun invoke() {
        println("bye, world!")
    }
}

// file scope -> singleton
val nonCaptureLambdaInstance = NonCaptureLambda()

val name = "Sungbin"

// 컴파일 전
val CaptureLambda = { println("[$name] bye, world!") }

// 컴파일 후
class CaptureLambda(private val name: String) : Function0<Unit> {
    override fun invoke() {
        println("[$name] bye, world!")
    }
}

// 매번 사용마다 CaptureLambda(name) 을 통해 새로운 인스턴스를 생성 후 invoke 함