fun main() {
  val url = "http://localhost:50025/?a=b&snack=milk-classic"
  val content = "<-- POST 200 $url (2ms)"
  val regex = Regex("""<-- POST 200 ${url.regexSafe().also(::println)} \(\d+ms\)""")
  println(content.matches(regex))
}

private fun String.regexSafe() = replace(Regex("[.^$|()\\[\\]{}*+?\\\\]")) { "\\${it.value}" }
