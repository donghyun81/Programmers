package level_2

import java.math.BigInteger
import kotlin.math.floor
import kotlin.math.sqrt

fun main(){
    println(110011.toString(10).split("0").filter { it.isNotEmpty() })
   println(PrimeNum().solution(234234,3))
}
class PrimeNum {
    fun solution(n: Int, k: Int): Int=n.toString(k).split("0").filter { it.isNotEmpty()&& isPrime(it.toLong()) }.size
    fun isPrime(num:Long):Boolean{
        if (num < 2) return false
        for(i in 2..floor(sqrt(num.toDouble())).toLong()){
            if(num%i == 0L) return false
        }
        return true
    }
}