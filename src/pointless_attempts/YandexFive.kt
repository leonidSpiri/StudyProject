package pointless_attempts

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    scanner.nextInt()
    val roadCount = scanner.nextInt()
    scanner.nextInt()
    var capitalCity = scanner.nextInt()
    for (i in 1 until roadCount) {
        val city1 = scanner.nextInt()
        val city2 = scanner.nextInt()
        if (city1 == capitalCity || city2 != capitalCity)
            capitalCity = -1
    }
    println(capitalCity)
}