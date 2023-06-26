package level_2

fun main(){
    Tuple().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")
}
class Tuple {
    fun solution(s: String): IntArray {
        val a = s.substring(2,s.length-2).split("},{").map { it.split(",") }.sortedBy { it.size }
        var answer = mutableSetOf<Int>()
        for(i in a.indices){
            for(j in a[i].indices){
                answer.add(a[i][j].toInt())
            }
        }
        return answer.toIntArray()
    }
}