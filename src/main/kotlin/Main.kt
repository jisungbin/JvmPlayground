import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private data class Node(var parent: Int = -1, var key: Int, var left: Int = -1, var right: Int = -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val caseCount = br.readLine()!!.toInt()
    repeat(caseCount) {
        val (contriesCount, _) = br.readLine()!!.split(" ").map { it.toInt() }
        repeat(contriesCount - 1) {
            br.readLine()!!
        }
        bw.write("${contriesCount - 1}\n")
    }

    br.close()
    bw.flush()
    bw.close()
}