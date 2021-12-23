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
        val newNodes = nodes[node]
        if (newNodes.size > 2 || (newNodes.size == 2 && node == rootNode) || (newNodes.size == 1 && node != rootNode)) {
            gigaNode = node
            treeHeight = height
        } else {
            for (newNode in newNodes) {
                if (newNode.key != parent) {
                    setGigaNodeAndTreeHeigth(node = newNode.key, parent = node, height = height + newNode.weight)
                }
            }
        }
    }

    fun dfs(node: Int = gigaNode, parent: Int = 0, weight: Int = 0) {
        val newNodes = nodes[node]
        if (newNodes.size == 1) {
            maxLeafNodeWeightSum = max(maxLeafNodeWeightSum, weight)
        } else {
            for (newNode in newNodes) {
                if (newNode.key != parent) {
                    dfs(node = newNode.key, parent = node, weight = weight + newNode.weight)
                }
            }
        }
    }

    if (nodeSize != 1) {
        setGigaNodeAndTreeHeigth()
        dfs()
    }

    bw.write("$treeHeight $maxLeafNodeWeightSum")

    br.close()
    bw.flush()
    bw.close()
}