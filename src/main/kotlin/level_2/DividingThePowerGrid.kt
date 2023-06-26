package level_2

import java.util.*
fun main(){
    val n = 7
}

class DividingThePowerGrid {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = -1
        val cnts = mutableListOf<Int>()
        val graph = Array(101){mutableListOf<Int>()}
        for(wire in wires){
            val (fst,sec) = wire
            graph[fst].add(sec)
            graph[sec].add(fst)
        }

        fun bfs(num:Int){
            val q = LinkedList<Int>()
            q.offer(num)
            var count = 0
            while(q.isNotEmpty()){
                val num = q.poll()
                count++
                if(graph[num].isEmpty()) continue
                for(i in graph[num]) q.offer(i)
            }
            cnts.add(count)
        }
        for(i in graph.indices) if(graph[i].isNotEmpty()) bfs(i)
        val sortCnt = cnts.sortedDescending()
        answer = sortCnt[0]-sortCnt[1]
        return answer
    }
}