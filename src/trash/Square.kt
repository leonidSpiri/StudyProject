package trash

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val xAxisArray = arrayListOf<Int>()
    val yAxisArray = arrayListOf<Int>()
    val firstRoom = scanner.nextLine()
    val secondRoom = scanner.nextLine()
    for (i in 0 until 4) {
        if (i % 2 == 0) {
            xAxisArray.add(firstRoom.split(" ")[i].toInt())
        } else {
            yAxisArray.add(firstRoom.split(" ")[i].toInt())
        }
    }
    for (i in 0 until 4) {
        if (i % 2 == 0) {
            xAxisArray.add(secondRoom.split(" ")[i].toInt())
        } else {
            yAxisArray.add(secondRoom.split(" ")[i].toInt())
        }
    }
    xAxisArray.sort()
    yAxisArray.sort()
    var maxSide = xAxisArray.last() - xAxisArray.first()
    maxSide = (yAxisArray.last() - yAxisArray.first()).coerceAtLeast(maxSide)
    println(maxSide * maxSide)

}