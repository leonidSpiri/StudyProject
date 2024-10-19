package pointless_attempts

fun main() {
    val (N, K, t) = readln().split(" ").map { it.toInt() }
    val heights = mutableListOf<Pair<Int, Int>>()

    // Чтение данных о высотах фейерверков и создание пары (высота, индекс)
    for (i in 1..N) {
        val h = readln().toInt()
        heights.add(Pair(h, i))
    }

    // Сортировка фейерверков по высоте
    heights.sortBy { it.first }

    var minDifference = Int.MAX_VALUE

    // Найти все возможные подотрезки длины K, которые содержат салют t
    for (i in 0..N - K) {
        val subList = heights.subList(i, i + K)
        val minHeight = subList.first().first
        val maxHeight = subList.last().first

        // Проверяем, входит ли фейерверк t в подотрезок
        if (subList.any { it.second == t }) {
            // Обновляем минимальную разность высот
            minDifference = minOf(minDifference, maxHeight - minHeight)
        }
    }

    // Вывод минимальной разности
    println(minDifference)
}