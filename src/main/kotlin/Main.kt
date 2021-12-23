import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

private data class Node(val key: Int, val weight: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (nodeSize, rootNode) = br.readLine()!!.split(" ").map { it.toInt() }
    val nodes = MutableList(nodeSize + 1) { mutableListOf<Node>() }

    var maxLeafNodeWeightSum = 0
    var gigaNode = 0
    var treeHeight = 0 // 트리 기둥 길이

    repeat(nodeSize - 1) {
        val (node, node2, weight) = br.readLine()!!.split(" ").map { it.toInt() }
        nodes[node].add(Node(key = node2, weight = weight))
        nodes[node2].add(Node(key = node, weight = weight))
    }

    fun setGigaNodeAndTreeHeigth(node: Int = rootNode, parent: Int = 0, height: Int = 0) {
        val newNodes = nodes[node].filterNot { it.key == parent }
        if (newNodes.isEmpty() || newNodes.size >= 2) {
            gigaNode = node
            treeHeight = height
        } else {
            setGigaNodeAndTreeHeigth(
                node = newNodes.first().key,
                parent = node,
                height = height + newNodes.first().weight
            )
        }
    }

    fun dfs(node: Int = gigaNode, parent: Int = 0, weight: Int = 0) {
        maxLeafNodeWeightSum = max(maxLeafNodeWeightSum, weight)

        for (newNode in nodes[node]) {
            if (newNode.key != parent) {
                dfs(node = newNode.key, parent = node, weight = weight + newNode.weight)
            }
        }
    }

    setGigaNodeAndTreeHeigth()
    dfs()

    bw.write("$treeHeight $maxLeafNodeWeightSum")

    br.close()
    bw.flush()
    bw.close()
}