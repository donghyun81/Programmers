package level_2

fun main(){
    val a = "1011010101"
    BinaryConversion().solution("110010101001")
}

class BinaryConversion {

    fun solution(s: String): IntArray {
        var answer = IntArray(2)
        var done = s
        while(done != "1"){
            answer[1] += done.count{it == '0'}
            done = done.filter{it == '1'}
            done = done.toLong().toString(2)
            println(done)
            answer[0] += 1
        }
        return answer
    }
}