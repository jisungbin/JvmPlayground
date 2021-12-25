import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max
import kotlin.math.min

private data class Node(var parent: Int = -1, var key: Int, var left: Int = -1, var right: Int = -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val nodeCount = br.readLine()!!.toInt()
    var rootNodeIndex = -1
    var nodeIndex = 1
    var maxLevel = 0
    val nodes = MutableList(nodeCount + 1) { Node(key = it) }
    val minIndexForEachLevels = MutableList(nodeCount + 1) { Int.MAX_VALUE }
    val maxIndexForEachLevels = MutableList(nodeCount + 1) { Int.MIN_VALUE }

    fun inOrder(rootIndex: Int = rootNodeIndex, level: Int = 1) {
        val root = nodes[rootIndex]
        maxLevel = max(maxLevel, level)
        if (root.left != -1) {
            inOrder(rootIndex = root.left, level = level + 1)
        }
        minIndexForEachLevels[level] = min(minIndexForEachLevels[level], nodeIndex)
        maxIndexForEachLevels[level] = nodeIndex
        nodeIndex++
        if (root.right != -1) {
            inOrder(rootIndex = root.right, level = level + 1)
        }
    }

    repeat(nodeCount - 1) {
        val (node, left, right) = br.readLine()!!.split(" ").map { it.toInt() }
        nodes[node].left = left
        nodes[node].right = right
        if (left != -1) {
            nodes[left].parent = node
        }
        if (right != -1) {
            nodes[right].parent = node
        }
    }

    for (i in 1..nodeCount) {
        if (nodes[i].parent == -1) {
            rootNodeIndex = i
            break
        }
    }

    inOrder()

    var largestSizeLevel = 1
    var largestSize = maxIndexForEachLevels.first() - minIndexForEachLevels.first() + 1
    for (i in 1..maxLevel) {
        val size = maxIndexForEachLevels[i] - minIndexForEachLevels[i] + 1
        if (largestSize < size) {
            largestSizeLevel = i
            largestSize = size
        }
    }

    bw.write("$largestSizeLevel $largestSize")

    br.close()
    bw.flush()
    bw.close()
}