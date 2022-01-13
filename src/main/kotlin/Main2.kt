import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.StringTokenizer

object Main {
    var classroom: Array<IntArray>
    var nearEmptySeatCnt: Array<IntArray>
    var N = 0
    var dx = intArrayOf(-1, 1, 0, 0)
    var dy = intArrayOf(0, 0, -1, 1)
    var list: MutableMap<Int, Student> = HashMap()

    @Throws(NumberFormatException::class, IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st: StringTokenizer
        N = br.readLine().toInt()
        val N2 = N * N
        var answer = 0
        classroom = Array(N) { IntArray(N) }
        fillNearEmptySeat()
        for (i in 0 until N2) {
            st = StringTokenizer(br.readLine(), " ")
            val num = st.nextToken().toInt()
            val s1 = st.nextToken().toInt()
            val s2 = st.nextToken().toInt()
            val s3 = st.nextToken().toInt()
            val s4 = st.nextToken().toInt()
            findSeat(num, intArrayOf(s1, s2, s3, s4))
        }
        for (i in 1..N2) {
            val student = list[i]
            var cnt = 0
            for (friend in student!!.flist) {
                if (Math.abs(list[friend]!!.x - student.x) + Math.abs(list[friend]!!.y - student.y) == 1) {
                    cnt++
                }
            }
            if (cnt == 1) answer += 1 else if (cnt == 2) answer += 10 else if (cnt == 3) answer += 100 else if (cnt == 4) answer += 1000
        }
        println(answer)
    }

    private fun findSeat(num: Int, friends: IntArray) {
        val nearScore = Array(N) { IntArray(N) } //주변에 친한 친구가 많은 위치를 찾기 위한 배열
        for (friend in friends) {
            if (list.containsKey(friend)) {
                val student = list[friend]
                val x = student!!.x
                val y = student.y
                for (i in 0..3) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && classroom[nx][ny] == 0) {
                        nearScore[nx][ny]++
                    }
                }
            }
        }
        var emptyCntMax = -1
        var nearScoreMax = -1
        var choiceX = -1
        var choiceY = -1
        for (i in 0 until N) {
            for (j in 0 until N) {
                if (classroom[i][j] != 0) continue
                if (nearScoreMax < nearScore[i][j]) {
                    choiceX = i
                    choiceY = j
                    nearScoreMax = nearScore[i][j]
                    emptyCntMax = nearEmptySeatCnt[i][j]
                } else if (nearScoreMax == nearScore[i][j] && emptyCntMax < nearEmptySeatCnt[i][j]) {
                    emptyCntMax = nearEmptySeatCnt[i][j]
                    choiceX = i
                    choiceY = j
                }
            }
        }
        classroom[choiceX][choiceY] = num
        list[num] = Student(choiceX, choiceY, friends)
        for (i in 0..3) {
            val nx = choiceX + dx[i]
            val ny = choiceY + dy[i]
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && classroom[nx][ny] == 0) {
                nearEmptySeatCnt[nx][ny]--
            }
        }
    }

    private fun fillNearEmptySeat() {
        nearEmptySeatCnt = Array(N) { IntArray(N) }
        for (i in 0 until N) {
            for (j in 0 until N) {
                var cnt = 4
                if (i == 0 || i == N - 1) cnt--
                if (j == 0 || j == N - 1) cnt--
                nearEmptySeatCnt[i][j] = cnt
            }
        }
    }

    internal class Student(var x: Int, var y: Int, var flist: IntArray)
}