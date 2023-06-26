package level_2

fun main() {
    StringCompression().solution("aabbaccc")
}

class StringCompression {
    fun solution(s: String): Int {
        var answer = s.length
        for(i in 1..s.length/2){
            var compressed = ""
            var prv = s.substring(0,i)
            var count = 1
            for(j in i..s.length step i){
                val range =  if (i+j > s.length) s.length else i+j
                var cur = s.substring(j,range)
                if (cur == prv) count++
                else {
                    compressed += if (count >1) "$count$prv" else prv
                    prv = cur
                    count = 1
                }
            }
            compressed += if (count >1) "$count$prv" else prv
            answer = minOf(compressed.length,answer)
        }
        return answer
    }
}