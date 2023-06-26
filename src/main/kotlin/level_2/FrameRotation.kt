package level_2
fun main(){
    FrameRotation().solution(6,6, arrayOf(intArrayOf(2,2,5,4), intArrayOf(3,3,6,6), intArrayOf(5,1,6,3)))
}
class FrameRotation {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val answer = mutableListOf<Int>()
        val table = Array(rows) { r -> IntArray(columns) { a -> r * columns + a + 1 } }
        for (query in queries) {
            val q = query.map { it - 1 }
            val tmp = table[q[0]][q[1]]
            var small = tmp

            // left
            for (i in q[0] + 1..q[2]) {
                table[i - 1][q[1]] = table[i][q[1]]
                small = minOf(small, table[i][q[1]])
            }
            for(i in table) println(i.toList())
            // bottom
            for (i in q[1] + 1..q[3]) {
                table[q[2]][i - 1] = table[q[2]][i]
                small = minOf(small, table[q[2]][i])
            }
            // right
            for (i in q[2] - 1 downTo q[0]) {
                table[i + 1][q[3]] = table[i][q[3]]
                small = minOf(small, table[i][q[3]])
            }
            // top
            for (i in q[3] - 1 downTo q[1]) {
                table[q[0]][i + 1] = table[q[0]][i]
                small = minOf(small, table[q[0]][i])
            }
            table[q[0]][q[1] + 1] = tmp

            answer.add(small)
        }

        return answer.toIntArray()
    }

}