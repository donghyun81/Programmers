package level_2

fun main() {
    println(Convert().solution("()))((()"))


}

class Convert() {
    fun solution(p: String): String {
        if(p.isEmpty() || isCorrect(p)) return p

        var answer = ""
        var splitIdx = splitIdx(p)
        val u = p.substring(0,splitIdx)
        val v = p.substring(splitIdx)

        if(isCorrect(u)) return u + solution(v)
        else {
            answer = "(" + solution(v) + ")"
            u.substring(1,u.length-1).forEach { answer += if (it == ')') '(' else ')' }
        }
        return answer
    }

    fun isCorrect(p:String):Boolean {
        var count = 0
        for(i in p.indices){
            if (p[i] == '(') count++
            if (p[i] == ')') count--
            if (count < 0) return false
        }
        return count==0
    }

    fun splitIdx(p: String): Int {
        var count = 0
        for(i in p.indices){
            if (p[i] == '(') count++
            if (p[i] == ')') count--
            if (count == 0) return i+1
        }
        return -1
    }
}
