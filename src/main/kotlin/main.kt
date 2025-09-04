fun main() {
  val start = 30
  val end = 64

  println(
    java.lang.Long.toBinaryString(
      (-1L ushr (
        // 실제로 설정해야 하는 비트까지의 시프팅 거리 계산
        64 -
          // 실제로 설정해야 하는 비트 수 계산
          (end - start)
        )
        ) shl start
    )
      .reversed()
      .chunked(10)
      .reversed()
      .joinToString("_"),
  )
}
