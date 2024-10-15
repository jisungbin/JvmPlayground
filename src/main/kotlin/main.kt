import java.text.DecimalFormat
import java.util.Currency
import java.util.Locale

fun main() {
  val formatter = DecimalFormat.getCurrencyInstance(Locale("th", "TH"))
  val formatter2 = DecimalFormat.getCurrencyInstance(Locale("hu", "HU")).apply {
    currency = Currency.getInstance(Locale.US)
  }
  val formatter3 = DecimalFormat.getCurrencyInstance(Locale("en", "HU")).apply {
    currency = Currency.getInstance(Locale.US)
  }
  val formatter4 = DecimalFormat.getCurrencyInstance(Locale("en", "US")).apply {
    currency = Currency.getInstance(Locale.US)
  }
  val formatter5 = DecimalFormat.getCurrencyInstance(Locale("en", "GB")).apply {
    currency = Currency.getInstance(Locale.US)
  }
  listOf(formatter, formatter2, formatter3, formatter4, formatter5).forEach {
    println(it.format(30672))
  }
}
