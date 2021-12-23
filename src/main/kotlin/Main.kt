import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 물을 가지고 있으며, 자식 정점이 있다면 자식 정점 중 하나를 골라 물을 1 준다. 자식 정점이 여러 개라면 동일한 확률로 그 중 하나를 고른다.
// -> 리프 노드일 때만 물을 가지고 있을 수 있음 (자식 노드가 있다면, 자식 노드에게 계속 물을 넘김)

private data class Node(var node2: Int = 0, var weight: Int = 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val nodeSize = br.readLine()!!.toInt()
    val nodes = MutableList(nodeSize + 1) { Node() }

    var treeWeight = 0
    var deepNode = 0

    repeat(nodeSize - 1) {
        val (node, node2, weight) = br.readLine()!!.split(" ").map { it.toInt() }
        nodes[node] = Node(node2 = node2, weight = weight)
        nodes[node2] = Node(node2 = node, weight = weight)
    }

    fun dfs(node: Int, parent: Int, weight: Int) {
        if (treeWeight < weight) {
            treeWeight = weight //
            deepNode = node
        }
    }

    br.close()
    bw.flush()
    bw.close()
}