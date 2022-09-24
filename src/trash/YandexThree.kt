package trash

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val array = mutableListOf<Pair<String, Int>>()
    val n = scanner.nextInt()
    for (i in 0 until n) {
        val word = scanner.next().lowercase(Locale.getDefault())[0].toString()
        var wasAdd = false
        for (j in array.indices) {
            if (array[j].first == word) {
                array[j] = Pair(word, array[j].second + 1)
                wasAdd = true
                break
            }
        }
        if (!wasAdd)
            array.add(Pair(word, 1))

    }
    array.sortBy { it.second }
    println(array.last().first)

}