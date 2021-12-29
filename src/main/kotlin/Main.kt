import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var taskCount = 0
    val (nodeCount, edgeCount) = br.readLine()!!.split(" ").map { it.toInt() }
    val parents = MutableList(nodeCount + 1) { it }

    fun findParent(node: Int): Int {
        return if (parents[node] == node) {
            node
        } else {
            val parent = findParent(parents[node])
            parents[node] = parent
            parent
        }
    }

    fun unionParent(node: Int, node2: Int) {
        val nodeParent = findParent(node)
        val node2Parent = findParent(node2)
        if (nodeParent == node2Parent) return
        parents[node2] = node
    }

    repeat(edgeCount) {
        val (node, node2) = br.readLine()!!.split(" ").map { it.toInt() }
        if (findParent(node) == findParent(node2)) {
            taskCount++
        }
        unionParent(node, node2)
    }

    for (i in 1..nodeCount) {
        if (findParent(i) != findParent(i + 1)) {
            unionParent(i, i + 1)
            taskCount++
        }
    }

    bw.write("$taskCount")

    br.close()
    bw.flush()
    bw.close()
}