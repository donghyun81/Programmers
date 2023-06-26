package level_2

fun main(){
    Hanoi().solution()

}
class Hanoi {
    fun solution(){
        val hanoi = mutableListOf("monitor", "dve" , "bon" )
        val n = readLine()!!.toInt()
        val answer = Array(3){""}
        fun hanoi(cnt:Int,start:List<String>,end:List<String>,to:List<String>){
            if(n == cnt) {
                answer[0] = (start.joinToString("\n")+"  ")
                answer[1] =(to.joinToString("\n")+"  ")
                answer[2] =(end.joinToString("\n")+"   ")
                return
            }
            val moveS = start.toMutableList()
            val moveE = end.toMutableList()
            val sValue = if (moveS.isNotEmpty()) moveS.removeFirst() else ""
            val eValue =if (moveE.isNotEmpty()) moveE.removeFirst() else ""
            hanoi(cnt+1,moveS,to+sValue,end)
            hanoi(cnt+1,to+eValue,moveE,start)
        }
        hanoi(1,hanoi, listOf(), listOf())
        for (i in answer) print(i)

    }
}