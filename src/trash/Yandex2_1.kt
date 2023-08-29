package trash

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    scanner.nextLine()
    val appConsumptions = scanner.nextLine().split(" ").map { it.toInt() }

    val totalConsumption = appConsumptions.sum()
    val batteryLife = 100 / totalConsumption

    println(batteryLife)
}
