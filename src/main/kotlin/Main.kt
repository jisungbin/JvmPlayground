import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.Scanner

// 물을 가지고 있으며, 자식 정점이 있다면 자식 정점 중 하나를 골라 물을 1 준다. 자식 정점이 여러 개라면 동일한 확률로 그 중 하나를 고른다.
// -> 리프 노드일 때만 물을 가지고 있을 수 있음 (자식 노드가 있다면, 자식 노드에게 계속 물을 넘김)

private data class Node(val key: Int, val weight: Int)

fun main() {
    val scanner = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val nodeSize = scanner.nextInt()
    val nodes = MutableList(nodeSize + 1) { mutableListOf<Node>() }

    var treeWeight = 0
    var deepNode = 0

    repeat(nodeSize - 1) {
        val node = scanner.nextInt()
        while (true) {
            val node2 = scanner.nextInt()
            if (node2 == -1) break
            val weight = scanner.nextInt()
            nodes[node].add(Node(key = node2, weight = weight))
        }
    }

    fun dfs(node: Int = 1, parent: Int = 0, weight: Int = 0) {
        if (treeWeight < weight) {
            treeWeight = weight // 트리 지름 더 큰 걸로 업데이트 (최대 지름으로 갱신)
            deepNode = node // 지름이 더 깊어지는 노드가, 제일 깊은 노드임
        }

        for (newNode in nodes[node]) {
            if (newNode.key != parent) {
                dfs(node = newNode.key, parent = node, weight = newNode.weight + weight)
            }
        }
    }

    dfs() // 제일 깊은 노드를 찾음
    dfs(node = deepNode) // 위에서 찾은 제일 깊은 노드로, 트리의 지름을 측정함

    bw.write("$treeWeight")

    scanner.close()
    bw.flush()
    bw.close()
}