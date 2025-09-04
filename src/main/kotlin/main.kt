fun main() {
  val start = 30
  val end = 64

  // 0000000000_0000000000_0000000000_1111111111_1111111111_1111111111_1111
  println(
    java.lang.Long.toBinaryString(
      (-1L ushr (
        // 실제로 설정해야 하는 비트까지의 시프팅 거리 계산
        64 -
          // 실제로 설정해야 하는 비트 수 계산
          (end - start) // 34
        // 30
        )
        )
    )
      .padStart(64, '0')
      .chunked(10)
      .joinToString("_"),
  )

  // 1111_1111111111_1111111111_1111111111_0000000000_0000000000_0000000000
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
      .padStart(64, '0')
      .reversed()
      .chunked(10)
      .reversed()
      .joinToString("_"),
  )
}
