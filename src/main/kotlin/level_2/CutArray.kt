package level_2

import java.util.*

fun main(){
    CutArray().solution(3,2,5)
}

class CutArray {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer = mutableListOf<Int>()
        val graph = Array(n){Array(n){0} }
        val visited = Array(n){BooleanArray(n)}
        val dx = listOf(1,0,-1,0)
        val dy = listOf(0,1,0,-1)
        fun isFrameIn(nx:Int,ny:Int) = nx>=0 && ny>=0 && nx<n && ny < n
        fun bfs(x:Int,y:Int){
            val q = LinkedList<Pair<Int,Int>>()
            q.offer(Pair(x,y))
            visited[x][y] = true
            graph[x][y] = 1
            while(q.isNotEmpty()){
                val cur = q.poll()
                for(drc in 0..3){
                    val nx = cur.first+dx[drc]
                    val ny = cur.second+dy[drc]
                    if(!isFrameIn(nx,ny) || visited[nx][ny]) continue
                    q.offer(Pair(nx,ny))
                    graph[nx][ny] = graph[cur.first][cur.second]+1
                    visited[nx][ny] = true
                }
            }
        }
        bfs(0,0)
        graph.flatten().forEachIndexed {idx,value ->
            if(idx in left..right) answer.add(value)
        }
        for (i in graph) println(i.toList())
        println(answer)
        return answer.toIntArray()
    }
}