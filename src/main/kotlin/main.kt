import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.asTypeName

enum class Type {
    Text,
}

private val textModifiers = listOf("A", "B")

internal val coreModifiers: Map<Type, List<String>>
    get() {
        val map = mutableMapOf<Type, List<String>>()
        map[Type.Text] = textModifiers
        return map
    }

fun main() {
    val fileSpec = FileSpec.builder("com.example", "MyClass")
        .addProperty(
            PropertySpec.builder(
                "coreModifiers",
                Map::class.asTypeName()
                    .parameterizedBy(
                        Type::class.asTypeName(),
                        List::class.asTypeName().parameterizedBy(String::class.asTypeName())
                    )
            )
                .getter(
                    FunSpec.getterBuilder()
                        .addStatement("val map = mutableMapOf<Type, List<String>>()")
                        .addStatement("map[Type.Text] = %L", textModifiers)
                        .addStatement("return map")
                        .build()
                )
                .build()
        )
        .build()

    val code = fileSpec.toString()
    println(code)
}