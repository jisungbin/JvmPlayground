private const val OPEN_RANGE = "{["
private const val CLOSE_RANGE = "]}"

fun main() {
  val text = "포키 님, {[최근 찾고 있던]} 이벤트는 어떠세요?"

  val startIndex = text.indexOf(OPEN_RANGE) + OPEN_RANGE.length
  val endIndex = text.indexOf(CLOSE_RANGE)

  val rangeText = text.substring(startIndex, endIndex)
  val cleanText = text.replace(OPEN_RANGE, "").replace(CLOSE_RANGE, "")

  println("원본 텍스트: $text")
  println("범위 텍스트: $rangeText")
  println("클린 텍스트: $cleanText")
}