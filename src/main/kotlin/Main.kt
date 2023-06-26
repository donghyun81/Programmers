//fun main(args: Array<String>) {
//    val a = arrayOf(arrayOf<Int>(), arrayOf<Int>())
//    var b = arrayOf(1,2,3)
//    var c = b.copyOf()
//    b[0] = 7
//    b.s
//    println(b.toList())
//    println(c.toList())
//
// a.flatten()
//}

//
//class Solution {
//    fun solution(weights: List<Int>): Long {
//        val weightSet = mutableSetOf<Int>()
//        val weight2cnt = mutableMapOf<Int, Int>()
//        var answer = 0L
//        weights.forEach { weight ->
//            weightSet.add(weight)
//            weight2cnt[weight] = weight2cnt.getOrDefault(weight, 0) + 1
//        }
//
//        for (weight in weightSet) {
//            val weightSize = weight2cnt[weight] ?: 0
//            answer += weightSize.toLong() * (weightSize - 1) / 2
//
//            for (i in 0..2) {
//                if (weight % divider[i] != 0) {
//                    continue
//                }
//
//                val calculatedWeight = (weight / divider[i]) * ratio[i]
//                val size = weight2cnt[calculatedWeight] ?: 0
//                answer += weightSize.toLong() * size.toLong()
//            }
//        }
//
//        return answer
//    }
//
//}

//class Solution {
//    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
//         var answer: Int = 0
//        val wantMap = mutableMapOf<String,Int>()
//        for((idx,fruit) in want.withIndex()) wantMap[fruit] = idx
//        for((idx,fruit) in disconut.withIndex()){
//            if(idx>=10){
//                val first = discount[i-10]
//
//            }
//        }
//
//        return answer
//    }
//}