package level_2

fun main(){
   println(MenuRenewal().solution(arrayOf("XYZ", "XWY", "WXA"), intArrayOf(2,3,4)).toList().sorted())
}

class MenuRenewal {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer= mutableListOf<String>()
        for(i in course){
            val combinations = mutableListOf<String>()
            for(order in orders){
                combinations += combinations(order.toCharArray(),i)
            }
            if(combinations.isNotEmpty()){
                val map = combinations.groupingBy{it}.eachCount()
                println(map)
                val max = map.values.maxOf{it}
                if(max >1 ) map.filter { it.value == max }.keys.forEach{ answer.add(it) }
            }

        }
        return answer.sorted().toTypedArray()
    }

    fun combinations(arr: CharArray, k: Int): List<String> {
        val result: MutableList<String> = ArrayList()
        val temp = CharArray(k)
        fun dfs(depth: Int, start: Int) {
            if (depth == k) {
                println(String(temp.sorted().toCharArray()))
                result.add(String(temp))
                return
            }
            for (i in start until arr.size) {
                temp[depth] = arr[i]
                dfs(depth + 1, i + 1)
            }
        }

        dfs(0, 0)

        return result
    }

}