package level_2

import java.util.*


fun main(){
    val data: Array<Array<String>> = arrayOf(
        arrayOf("science", "12:40", "50"),
        arrayOf("music", "12:20", "40"),
        arrayOf("history", "14:00", "30"),
        arrayOf("computer", "12:30", "100")
    )
    Assignment().solution(data)
}
class Assignment {
    fun solution(plans: Array<Array<String>>): Array<String> {
        var answer = mutableListOf<String>()
        var plans = plans.sortedBy{timeToMinute(it[1])}

        val q = LinkedList<Pair<String,Int>>()
        for(idx in plans.indices) {
            var(cName, cStart, cPlaytime) = plans[idx]
            println(q)
            if(idx+1 == plans.size) {
                answer.add(cName)
                while(q.isNotEmpty()) answer.add(q.removeLast().first)
                break
            }
            var(nName, nStart, nPlaytime) = plans[idx+1]
            var curTime = timeToMinute(nStart) - timeToMinute(cStart)
            if(curTime >= cPlaytime.toInt()){
                curTime -= cPlaytime.toInt()
                answer.add(cName)
                while(q.isNotEmpty() && curTime >= 0){
                    val (name,time)= q.removeLast()
                    if(curTime < time){
                        q.offer(Pair(name,time-curTime))
                        break
                    }
                    else {
                        answer.add(name)
                        curTime -= time
                    }
                }
            }
            else q.offer(Pair(cName,cPlaytime.toInt()-curTime))
        }
        println(answer)
        return answer.toTypedArray()
    }

    fun timeToMinute(time:String) :Int{
        val (h,m) = time.split(":").map{it.toInt()}
        return h*60+m
    }
}
