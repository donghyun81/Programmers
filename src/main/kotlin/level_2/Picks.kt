package level_2

fun main(){
    val a = intArrayOf(1, 3, 2)
    val b = arrayOf( "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone")
    Picks().solution(a,b)
}
class Picks {
    private var answer = Int.MAX_VALUE
    lateinit var picks :IntArray
    lateinit var minerals:Array<String>

    fun solution(picks: IntArray, minerals: Array<String>): Int {
        val  a = listOf("diamond","iron","stone")
        for(mineral in 0..2){
            if (picks[mineral] != 0) {
                val pick = picks.clone()
                pick[mineral]--
                dfs(0, 0, a[mineral])
            }
        }
        println(answer)
        return answer
    }

    fun dfs(sum: Int, index: Int, mineral: String) {
        var sum = sum
        for (i in index until index + 5) {
            if (i == minerals.size) {
                answer = Math.min(answer, sum)
                return
            }
            sum += if (mineral == "diamond") 1 else if (mineral == "iron") {
                if (minerals[i] == "diamond") 5 else 1
            } else {
                if (minerals[i] == "diamond") 25 else if (minerals[i] == "iron") 5 else 1
            }
        }
        var hasNext = false
        if (picks[0] > 0) {
            val pick = picks.clone()
            pick[0]--
            hasNext = true
            dfs(sum, index + 5, "diamond",)

        }
        if (picks[1] > 0) {
            val pick = picks.clone()
            pick[1]--
            hasNext = true
            dfs(sum, index + 5, "iron",)
        }

        if (picks[2] > 0) {
            val pick = picks.clone()
            pick[2]--
            hasNext = true
            dfs(sum, index + 5, "stone",)
        }
        if (!hasNext) answer = Math.min(answer, sum)
    }
}