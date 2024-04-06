@file:Suppress("NOTHING_TO_INLINE")

@JvmInline
value class NodeKind(val mask: Int) {
  inline infix fun or(other: NodeKind): Int = mask or other.mask
  inline infix fun or(other: Int): Int = mask or other
}

interface Node {
  val kindSet: Int
}

inline infix fun Int.or(other: NodeKind): Int = this or other.mask

inline operator fun Int.contains(value: NodeKind) = this and value.mask != 0

object Nodes {
  val MapNodeComparator = Comparator<Node> { a, b -> a.kindSet.compareTo(b.kindSet) }

  inline val Any get() = NodeKind(0b1 shl 0)
  inline val LayoutNodeProvider get() = NodeKind(0b1 shl 1)
  inline val LayoutNodeConsumer get() = NodeKind(0b1 shl 2)
  inline val ContentUpdater get() = NodeKind(0b1 shl 3)
  inline val ContentReader get() = NodeKind(0b1 shl 4)
}

fun main() {
  val layoutNodeProviderNode = object : Node {
    override val kindSet: Int = Nodes.LayoutNodeProvider.mask
    override fun toString(): String = "LayoutNodeProviderNode"
  }
  val layoutNodeConsumerNode = object : Node {
    override val kindSet: Int = Nodes.LayoutNodeConsumer.mask
    override fun toString(): String = "LayoutNodeConsumerNode"
  }
  val layoutNodeConsumerNode2 = object : Node {
    override val kindSet: Int = Nodes.LayoutNodeConsumer.mask
    override fun toString(): String = "LayoutNodeConsumerNode2"
  }
  val contentUpdateNode = object : Node {
    override val kindSet: Int = Nodes.ContentUpdater or Nodes.ContentReader
    override fun toString(): String = "ContentUpdateNode"
  }
  val contentReaderNode = object : Node {
    override val kindSet: Int = Nodes.ContentReader.mask
    override fun toString(): String = "ContentReaderNode"
  }
  listOf(layoutNodeProviderNode, layoutNodeConsumerNode, layoutNodeConsumerNode2, contentUpdateNode, contentReaderNode)
    .sortedWith(Nodes.MapNodeComparator)
    .forEach { println(it) }
}