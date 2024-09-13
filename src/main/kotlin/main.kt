import java.math.BigDecimal
import java.text.NumberFormat

private val formatter = NumberFormat.getInstance()

private fun BigDecimal.numberFormat(): String {
  val number = toLong()
  val floatingNumber = toString().substringAfterLast('.', missingDelimiterValue = "")
  return formatter.format(number) + if (floatingNumber.isNotEmpty()) ".$floatingNumber" else ""
}

fun main() {
  val number = BigDecimal("123456789.123456789000000")
  println(number.numberFormat())
}
