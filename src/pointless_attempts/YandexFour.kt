package pointless_attempts

import java.util.*
import kotlin.math.max

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val wArray = mutableListOf<Int>()
    val hArray = mutableListOf<Int>()
    val lArray = mutableListOf<Int>()
    for (i in 0 until n) {
        scanner.next()
        wArray.add(scanner.nextInt())
        hArray.add(scanner.nextInt())
        lArray.add(scanner.nextInt())
    }
    wArray.sort()
    hArray.sort()
    lArray.sort()
    val middle = if (n % 2 == 0) n / 2 - 1 else n / 2
    val wMiddle = wArray[middle]
    val hMiddle = hArray[middle]
    val lMiddle = lArray[middle]
    var result = Int.MIN_VALUE
    result = max(result, wMiddle)
    result = max(result, hMiddle)
    result = max(result, lMiddle)
    println(result)
}
