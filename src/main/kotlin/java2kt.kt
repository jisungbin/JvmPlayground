import com.squareup.kotlinpoet.ANY
import com.squareup.kotlinpoet.BOOLEAN
import com.squareup.kotlinpoet.BYTE
import com.squareup.kotlinpoet.CHAR
import com.squareup.kotlinpoet.CHAR_SEQUENCE
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.DOUBLE
import com.squareup.kotlinpoet.ENUM
import com.squareup.kotlinpoet.FLOAT
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.LIST
import com.squareup.kotlinpoet.LONG
import com.squareup.kotlinpoet.MAP
import com.squareup.kotlinpoet.SET
import com.squareup.kotlinpoet.SHORT
import com.squareup.kotlinpoet.STRING

// https://github.com/square/kotlinpoet/blob/dbc1599f53bccdd5daf65198097ff4b182269009/interop/javapoet/src/main/kotlin/com/squareup/kotlinpoet/javapoet/j2kInterop.kt#L47-L72
fun ClassName.kotlin() = when (this) {
  JavaName.BOOLEAN -> BOOLEAN
  JavaName.BYTE -> BYTE
  JavaName.CHAR -> CHAR
  JavaName.SHORT -> SHORT
  JavaName.INT -> INT
  JavaName.LONG -> LONG
  JavaName.FLOAT -> FLOAT
  JavaName.DOUBLE -> DOUBLE
  JavaName.OBJECT -> ANY
  JavaName.CHAR_SEQUENCE -> CHAR_SEQUENCE
  JavaName.STRING -> STRING
  JavaName.LIST -> LIST
  JavaName.SET -> SET
  JavaName.MAP -> MAP
  JavaName.ENUM -> ENUM
  else -> this
}

// https://github.com/square/javapoet/blob/09093974bc673e7464b81a89ce0cfc2fdce588cf/src/main/java/com/squareup/javapoet/TypeName.java#L80-L88
private object JavaName {
  val BOOLEAN = ClassName("java.lang", "Boolean")
  val BYTE = ClassName("java.lang", "Byte")
  val SHORT = ClassName("java.lang", "Short")
  val INT = ClassName("java.lang", "Integer")
  val LONG = ClassName("java.lang", "Long")
  val CHAR = ClassName("java.lang", "Character")
  val FLOAT = ClassName("java.lang", "Float")
  val DOUBLE = ClassName("java.lang", "Double")
  val STRING = ClassName("java.lang", "String")
  val CHAR_SEQUENCE = ClassName("java.lang", "CharSequence")
  val OBJECT = ClassName("java.lang", "Object")
  val LIST = ClassName("java.util", "List")
  val SET = ClassName("java.util", "Set")
  val MAP = ClassName("java.util", "Map")
  val ENUM = ClassName("java.lang", "Enum")
}
