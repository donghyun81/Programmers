package level_2

fun main(){

    VowelDictionary().solution("AAAEE")

}
class VowelDictionary {
        val arr = arrayOf("A", "E", "I", "O", "U")
        val result = mutableListOf<String>()

        fun solution(word: String): Int {
            dfs("")
            result.forEachIndexed { idx, s ->
                if(s == word) return idx
            }
            return -1
        }

        fun dfs(str: String) {
            if (str.length > 5) return
            result.add(str)
            for (a in arr) {
                dfs(str + a)
            }
        }
}