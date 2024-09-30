fun main() {
  val regex = "\\{\\[(.*?)]}".toRegex()
  val text = "How about the {[recently searched for]} event?"
  val matchResult = regex.find(text)
  val (extractedText, extractedRange) = matchResult?.groups?.get(1) ?: return
  val cleanText = regex.replace(text) { extractedText }

  println("Result: $cleanText")
  println("Extracted text: $extractedText")
  println("Extracted range: $extractedRange")

  // Adjust the range for cleanText
  val adjustedStart = extractedRange.first - 2 // Remove 2 characters for "{["
  val adjustedEnd = adjustedStart + extractedText.length - 1

  println("Adjusted range in cleanText: ${cleanText.substring(adjustedStart..adjustedEnd)} ($adjustedStart..$adjustedEnd)")
}