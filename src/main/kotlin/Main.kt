import Fakies.random
import java.lang.reflect.Constructor
import kotlin.random.Random

sealed class StringType(val length: Int) {
    class Korean(length: Int = 10) : StringType(length)
    class English(length: Int = 10) : StringType(length)
    class Lipsum(length: Int = 10) : StringType(length)
}

@Suppress("MemberVisibilityCanBePrivate")
object Fakies {

    @PublishedApi
    internal fun <T> createEntity(constructor: Constructor<T>, vararg args: Any): T {
        return constructor.newInstance(*args)
    }

    @PublishedApi
    internal fun randomString(stringRandomType: StringType): String {
        return when (stringRandomType) {
            is StringType.Korean -> korean(stringRandomType.length)
            is StringType.English -> english(stringRandomType.length)
            is StringType.Lipsum -> LIPSUM.substring(0..stringRandomType.length)
        }
    }

    @Suppress("unused")
    inline fun <reified T> random(
        count: Int = 1,
        stringRandomType: StringType = StringType.Lipsum()
    ): List<T> {
        return List(count) {
            val fields = T::class.java.declaredFields
            val elements = Array(fields.count()) { i ->
                when (fields[i].type) {
                    Int::class.java -> Random.nextInt()
                    Float::class.java -> Random.nextFloat()
                    Double::class.java -> Random.nextDouble()
                    Boolean::class.java -> Random.nextBoolean()
                    String::class.java -> randomString(stringRandomType)
                    else -> createEntity(fields[i]::class.java.constructors.first())
                }
            }
            createEntity(T::class.java.constructors.first(), *elements) as T
        }
    }

    val LIPSUM = """
        Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
        sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
        Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris 
        nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in 
        reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
        Excepteur sint occaecat cupidatat non proident, sunt in 
        culpa qui officia deserunt mollit anim id est laborum.
    """.trimIndent()

    private val koreanCharPool = ('가'..'힣')
    private val englishCharPool = ('a'..'z') + ('A'..'Z')

    fun korean(length: Int = 10) = List(length) { koreanCharPool.random() }.joinToString("")
    fun english(length: Int = 0) = List(length) { englishCharPool.random() }.joinToString("")
}

data class Test(val a: Int = 1)

fun main() {
    println(random<Test>(1))
}
