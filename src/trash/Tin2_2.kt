package trash

fun main(){
    val (n, c, d) = readLine()!!.split(" ").map { it.toInt() }
    val dangers = readLine()!!.split(" ").map { it.toInt() }

    var left = -1e9.toInt() // Начальное значение опасности (минимально возможное)
    var right = 1e9.toInt() // Конечное значение опасности (максимально возможное)

    while (left + 1 < right) {
        val mid = (left + right) / 2
        if (isPossible(dangers, mid, c, d)) {
            right = mid
        } else {
            left = mid
        }
    }

    val result = MutableList(n) { right }
    println(result.joinToString(" "))
}

fun isPossible(dangers: List<Int>, target: Int, maxChanges: Int, changeValue: Int): Boolean {
    val changesNeeded = dangers.count { it > target }

    return changesNeeded <= maxChanges && changesNeeded * changeValue <= maxChanges
}