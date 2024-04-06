@file:Suppress("NOTHING_TO_INLINE")

@JvmInline
value class ContributionKind(val mask: Int) {
  inline infix fun or(other: Int): Int = mask or other
  inline infix fun or(other: ContributionKind): ContributionKind = ContributionKind(mask or other.mask)
}

inline infix fun Int.or(other: ContributionKind): Int = this or other.mask
inline operator fun Int.contains(value: ContributionKind): Boolean = this and value.mask != 0
inline operator fun ContributionKind.contains(value: ContributionKind): Boolean = this.mask and value.mask != 0

object Contributions {
  inline val None get() = ContributionKind(0b1 shl 0)
  inline val NaverMap get() = ContributionKind(0b1 shl 1)
  inline val MapView get() = ContributionKind(0b1 shl 2)
  inline val Overlay get() = ContributionKind(0b1 shl 3)
}

fun main() {
  val contributions = Contributions.NaverMap or Contributions.MapView
  // this.mask and value.mask
  println("Contributions.NaverMap in contributions: ${(Contributions.NaverMap.mask and Contributions.NaverMap.mask).toString(2)}")
  println("Contributions.NaverMap in contributions: ${(Contributions.None.mask and contributions.mask).toString(2)}")
  println("Contributions.NaverMap in contributions: ${Contributions.NaverMap in contributions}")
  println("contributions in contributions: ${contributions in contributions}")
  println("contributions: " + contributions.mask.toString(2))
  println("Contributions.None: " + Contributions.None.mask.toString(2))
  println("Contributions.NaverMap: " + Contributions.NaverMap.mask.toString(2))
  println("Contributions.MapView: " + Contributions.MapView.mask.toString(2))
  println("Contributions.Overlay: " + Contributions.Overlay.mask.toString(2))
}
