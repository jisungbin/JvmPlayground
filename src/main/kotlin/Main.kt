import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

private data class Node(var node: Int, var weight: Int = 0)

@Suppress("BlockingMethodInNonBlockingContext")
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val nodeCount = br.readLine()!!.toInt()
    val nodes = List(nodeCount + 1) { mutableListOf<Node>() }

    repeat(nodeCount - 1) {
        val (node, node2, weight) = br.readLine()!!.split(" ").map { it.toInt() }
        nodes[node].add(Node(node2, weight))
        nodes[node2].add(Node(node, weight))
    }

    fun bfs(node: Int, ignoreNode: Int = 0): Node {
        val bfsQueue: Queue<Node> = LinkedList()
        val vis = MutableList(nodeCount + 1) { false }
        val largestWeigthNode = Node(node)
        bfsQueue.offer(largestWeigthNode)

        while (bfsQueue.isNotEmpty()) {
            val (_node, _weight) = bfsQueue.poll()
            vis[_node] = true

            if (_node != ignoreNode && _weight > largestWeigthNode.weight) {
                largestWeigthNode.node = _node
                largestWeigthNode.weight = _weight
            }

            for (newNode in nodes[_node]) {
                if (!vis[newNode.node]) {
                    bfsQueue.offer(newNode.apply { weight += _weight })
                }
            }
        }

        return largestWeigthNode
    }

    val node = bfs(1, 0) // 제일 끝에 있는 노드
    val node2 = bfs(node.node) // 제일 끝에 있는 노드 2

    val result = bfs(node.node, node2.node)
    val result2 = bfs(node2.node, node.node)

    bw.write("${max(result.weight, result2.weight)}")

    br.close()
    bw.flush()
    bw.close()
}