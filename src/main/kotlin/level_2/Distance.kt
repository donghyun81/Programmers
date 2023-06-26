package level_2


import java.util.*

fun main(){
    val places = arrayOf(
    arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
    arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
    arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
    arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
    arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP")
)
    println(Distance().solution(places).toList())

}
class Distance (){
    fun bfs(p: Array<String>): Int {
        val start = mutableListOf<MutableList<Int>>()

        for (i in 0 until 5) {
            for (j in 0 until 5) {
                if (p[i][j] == 'P') {
                    start.add(mutableListOf(i, j))
                }
            }
        }

        for (s in start) {
            val queue: Queue<List<Int>> = LinkedList(listOf(s)) // 큐에 초기값
            val visited = Array(5) { IntArray(5) } // 방문 처리 리스트
            val distance = Array(5) { IntArray(5) } // 경로 길이 리스트
            visited[s[0]][s[1]] = 1

            while (queue.isNotEmpty()) {
                val (y, x) = queue.poll()
                val dx = listOf(-1, 1, 0, 0) // 좌우
                val dy = listOf(0, 0, -1, 1) // 상하

                for (i in 0 until 4) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]

                    if (nx in 0 until 5 && ny in 0 until 5 && visited[ny][nx] == 0) {
                        if (p[ny][nx] == 'O') {
                            queue.offer(listOf(ny, nx))
                            visited[ny][nx] = 1
                            distance[ny][nx] = distance[y][x] + 1
                        }

                        if (p[ny][nx] == 'P' && distance[y][x] <= 1) {
                            return 0
                        }
                    }
                }
            }
            for (i in distance) println(i.toList())
            println("----------")
        }
        return 1
    }

    fun solution(places: Array<Array<String>>): IntArray {
        val answer = mutableListOf<Int>()
        for (i in places) {
            answer.add(bfs(i))
        }
        return answer.toIntArray()
    }

}


