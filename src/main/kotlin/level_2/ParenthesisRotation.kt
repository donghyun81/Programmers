package level_2

import java.util.*

fun main(){
    ParenthesisRotation().solution("[)(]")
}

class ParenthesisRotation {
    fun solution(s: String): Int {
        var answer: Int = 0
        var moveS = s
        for(i in 0 until s.length) {
            val parenthesisCnts = IntArray(3)
            for (i in moveS) {
                when (i) {
                    '[' -> parenthesisCnts[0]++
                    ']' -> parenthesisCnts[0]--
                    '{' -> parenthesisCnts[1]++
                    '}' -> parenthesisCnts[1]--
                    '(' -> parenthesisCnts[2]++
                    ')' -> parenthesisCnts[2]--
                }
                if (parenthesisCnts.any { it < 0 }) break
            }
            if (parenthesisCnts.all { it == 0 }) answer++
            val rotate = moveS.toMutableList()
            Collections.rotate(rotate, 1)
            moveS = rotate.joinToString("")
        }
        return answer
    }
}