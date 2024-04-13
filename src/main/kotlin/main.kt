@file:OptIn(DelicateKotlinPoetApi::class)

import com.squareup.kotlinpoet.ARRAY
import com.squareup.kotlinpoet.BOOLEAN
import com.squareup.kotlinpoet.BYTE
import com.squareup.kotlinpoet.BYTE_ARRAY
import com.squareup.kotlinpoet.CHAR
import com.squareup.kotlinpoet.CHAR_ARRAY
import com.squareup.kotlinpoet.DOUBLE
import com.squareup.kotlinpoet.DOUBLE_ARRAY
import com.squareup.kotlinpoet.DelicateKotlinPoetApi
import com.squareup.kotlinpoet.FLOAT
import com.squareup.kotlinpoet.FLOAT_ARRAY
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.INT_ARRAY
import com.squareup.kotlinpoet.LONG
import com.squareup.kotlinpoet.LONG_ARRAY
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.SHORT
import com.squareup.kotlinpoet.SHORT_ARRAY
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.UNIT
import com.squareup.kotlinpoet.asClassName
import io.github.classgraph.ArrayTypeSignature
import io.github.classgraph.BaseTypeSignature
import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassRefTypeSignature

fun main() {
  val helloWorld =
    ClassGraph()
      .enableClassInfo()
      .enableMethodInfo()
      .acceptPackagesNonRecursive("")
      .scan()
      .getClassInfo("HelloWorld")

  helloWorld.methodInfo.forEach { method ->
    method.parameterInfo.forEach { param ->
      val descriptor = param.typeSignatureOrTypeDescriptor
      println(param.toStringWithSimpleNames())

      when (descriptor) {
        is BaseTypeSignature -> println(descriptor.typed().kotlin())
        is ArrayTypeSignature -> println(
          when (val componentType = descriptor.loadElementClass()) {
            Byte::class.javaPrimitiveType!! -> BYTE_ARRAY
            Char::class.javaPrimitiveType!! -> CHAR_ARRAY
            Short::class.javaPrimitiveType!! -> SHORT_ARRAY
            Int::class.javaPrimitiveType!! -> INT_ARRAY
            Long::class.javaPrimitiveType!! -> LONG_ARRAY
            Float::class.javaPrimitiveType!! -> FLOAT_ARRAY
            Double::class.javaPrimitiveType!! -> DOUBLE_ARRAY
            else -> ARRAY.parameterizedBy(componentType.asClassName().kotlin())
          }
        )
        is ClassRefTypeSignature -> println(descriptor.foldInnerTypes())
      }

      println("---")
    }
  }
}

private fun BaseTypeSignature.typed() = when (val type = type) {
  Void.TYPE -> UNIT
  Boolean::class.javaPrimitiveType -> BOOLEAN
  Byte::class.javaPrimitiveType -> BYTE
  Short::class.javaPrimitiveType -> SHORT
  Int::class.javaPrimitiveType -> INT
  Long::class.javaPrimitiveType -> LONG
  Char::class.javaPrimitiveType -> CHAR
  Float::class.javaPrimitiveType -> FLOAT
  Double::class.javaPrimitiveType -> DOUBLE
  else -> error("Unsupported primitive type: $type")
}

private fun ClassRefTypeSignature.foldInnerTypes(): TypeName {
  val parent = loadClass().asClassName().kotlin()
  if (typeArguments.isNotEmpty()) {
    val trailing = typeArguments.map { argu -> (argu.typeSignature as ClassRefTypeSignature).foldInnerTypes() }
    return parent.parameterizedBy(trailing)
  }
  return parent
}
