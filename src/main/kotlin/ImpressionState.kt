@file:Suppress("NOTHING_TO_INLINE")

import androidx.compose.runtime.IntState
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.snapshots.Snapshot

@Stable
@JvmInline public value class ImpressionState
private constructor(@PublishedApi internal val packedState: MutableIntState) : IntState by packedState {
  @Suppress("UNCHECKED_CAST")
  public /*inline*/ constructor() : this(mutableIntStateOf(0))

  // TODO KT-26939
  @Suppress("UNCHECKED_CAST")
  public /*inline*/ constructor(
    impressionEnabled: Boolean = false,
    impressionCollected: Boolean = false,
    impressionPrecondition: Boolean = false,
    impressionDebugUIEnabled: Boolean = false,
  ) : this(
    mutableIntStateOf(
      bitMask(
        impressionEnabled,
        impressionCollected,
        impressionPrecondition,
        impressionDebugUIEnabled,
      )
    ),
  )

  public inline var impressionEnabled: Boolean
    get() = packedState.intValue isBitSet 0
    set(value) {
      packedState.intValue = packedState.intValue.withBit(0, value)
    }

  public inline var impressionCollected: Boolean
    get() = packedState.intValue isBitSet 1
    set(value) {
      packedState.intValue = packedState.intValue.withBit(1, value)
    }

  public inline var impressionPrecondition: Boolean
    get() = packedState.intValue isBitSet 2
    set(value) {
      packedState.intValue = packedState.intValue.withBit(2, value)
    }

  public inline var impressionDebugUIEnabled: Boolean
    get() = packedState.intValue isBitSet 3
    set(value) {
      packedState.intValue = packedState.intValue.withBit(3, value)
    }

  override fun toString(): String =
    Snapshot.withoutReadObservation {
      "ImpressionState(" +
        "impressionEnabled=$impressionEnabled, " +
        "impressionCollected=$impressionCollected, " +
        "impressionPrecondition=$impressionPrecondition, " +
        "impressionDebugUIEnabled=$impressionDebugUIEnabled" +
        ")"
    }
}

// Set the bit at a certain index
@PublishedApi
internal inline fun Int.withBit(index: Int, value: Boolean): Int =
  if (value) {
    this or (1 shl index)
  } else {
    this and (1 shl index).inv()
  }

// Create a bitmask with the following bits
private /*inline*/ fun bitMask(vararg values: Boolean): Int =
  values.foldIndexed(0) { index, acc, bit -> acc.withBit(index, bit) }

// Check if a bit at a certain index is set
@PublishedApi
internal inline infix fun Int.isBitSet(index: Int): Boolean = (this and (1 shl index)) != 0
