package level_2

import java.time.LocalTime
import kotlin.math.ceil

fun main(){
    val data = arrayOf(
        "05:34 5961 IN",
        "06:00 0000 IN",
        "06:34 0000 OUT",
        "07:59 5961 OUT",
        "07:59 0148 IN",
        "18:59 0000 IN",
        "19:09 0148 OUT",
        "22:59 5961 IN",
        "23:00 5961 OUT"
    )
    Solution().solution(intArrayOf(1, 461, 1, 10), arrayOf("00:00 1234 IN"))
}

    class Solution {
        fun solution(fees: IntArray, records: Array<String>): IntArray {
            val (basicTime, basicFee, unitTime, unitFee) = fees
            val busInTimeMap = mutableMapOf<Int, Int>() // 버스 입차 시간 저장
            val busIsInMap = mutableMapOf<Int, Boolean>() // 버스 입차 상태 저장
            val busTravelTimeMap = mutableMapOf<Int, Int>() // 버스 총 주행 시간 저장
            val a = mutableListOf<Int>()
            a.distinct()

            for (record in records) {
                val (timeS, busNumS, command) = record.split(" ")
                val (hour, minute) = timeS.split(":").map { it.toInt() }
                val time = hour * 60 + minute
                val busNum = busNumS.toInt()

                when (command) {
                    "IN" -> {
                        busInTimeMap[busNum] = time
                        busIsInMap[busNum] = true
                    }
                    "OUT" -> {
                        busTravelTimeMap[busNum] = (busTravelTimeMap[busNum] ?: 0) + (time - busInTimeMap[busNum]!!)
                        busInTimeMap[busNum] = 0
                        busIsInMap[busNum] = false
                    }
                }
            }

            for ((busNum, startTime) in busInTimeMap) {
                if (busIsInMap[busNum] == true) {
                    val endTime = 24 * 60 - 1
                    val totalTime = endTime - startTime
                    busTravelTimeMap[busNum] = (busTravelTimeMap[busNum] ?: 0) + totalTime
                }
            }

            val busFees = mutableListOf<Int>()
            for (busNum in busTravelTimeMap.keys.sorted()) {
                val totalTime = busTravelTimeMap[busNum]!!
                val totalFee = calculateFee(totalTime, fees)
                busFees.add(totalFee)
            }
            return busFees.toIntArray()
        }
        fun calculateFee(totalTime: Int, fees: IntArray): Int {
            val (basicTime, basicFee, unitTime, unitFee) = fees
            return if (totalTime <= basicTime) {
                basicFee
            } else {
                basicFee + ((totalTime - basicTime - 1) / unitTime + 1) * unitFee
            }
        }

    }