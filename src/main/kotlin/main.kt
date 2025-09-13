import kotlin.reflect.KProperty

object Test

context(a: Test)
operator fun <T> Unit.getValue(thisObj: Any?, property: KProperty<*>): T =
  doubleValue
