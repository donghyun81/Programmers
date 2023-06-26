package level_2

fun main(){
    val list = listOf(listOf(80, 20), listOf(50, 40), listOf(30, 10))
    val array = list.map { it.toIntArray() }.toTypedArray()
    Fatigue().solution(80,array)
}

class Fatigue(){
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer: Int = -1
        var fatigue = k
        fun dfs(depth:Int,count:Int){
            if(depth == dungeons.size){
                println(count)
                answer = maxOf(answer,count)
                return
            }
            for(i in dungeons){
                if(i[0]>fatigue) continue
                fatigue -= i[1]
                dfs(depth+1,count+1)
            }
        }
        dfs(0,0)
        return answer
    }
}