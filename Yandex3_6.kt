package pointless_attempts

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    // Чтение количества пешек
    val N = scanner.nextInt()
    val pawns = mutableSetOf<Pair<Int, Int>>()
    val rows = mutableMapOf<Int, MutableList<Int>>()
    val cols = mutableMapOf<Int, MutableList<Int>>()
    val diag1 = mutableMapOf<Int, MutableList<Int>>()  // Диагональ y - x = const
    val diag2 = mutableMapOf<Int, MutableList<Int>>()  // Диагональ y + x = const

    for (i in 0 until N) {
        val x = scanner.nextInt()
        val y = scanner.nextInt()
        pawns.add(Pair(x, y))

        rows.computeIfAbsent(x) { mutableListOf() }.add(y)
        cols.computeIfAbsent(y) { mutableListOf() }.add(x)
        diag1.computeIfAbsent(y - x) { mutableListOf() }.add(x)
        diag2.computeIfAbsent(y + x) { mutableListOf() }.add(x)
    }

    // Чтение количества запросов
    val Q = scanner.nextInt()

    // Определяем направления для коня
    val knightMoves = arrayOf(
        Pair(-2, -1), Pair(-1, -2), Pair(1, -2), Pair(2, -1),
        Pair(2, 1), Pair(1, 2), Pair(-1, 2), Pair(-2, 1)
    )

    // Функция для подсчёта атакованных клеток конём
    fun countKnightAttacks(x: Int, y: Int): Int {
        var count = 0
        for ((dx, dy) in knightMoves) {
            if (pawns.contains(Pair(x + dx, y + dy))) {
                count++
            }
        }
        return count
    }

    // Функция для подсчёта атакованных клеток пешкой
    fun countPawnAttacks(x: Int, y: Int): Int {
        var count = 0
        if (pawns.contains(Pair(x + 1, y - 1))) count++
        if (pawns.contains(Pair(x + 1, y + 1))) count++
        return count
    }

    // Функция для нахождения ближайшей пешки в ряду
    fun findClosestInRow(x: Int, y: Int): Int {
        var count = 0
        val rowPawns = rows[x] ?: return 0
        rowPawns.sort()
        for (pawnY in rowPawns) {
            if (pawnY < y || pawnY > y) count++
        }
        return count
    }

    // Функция для нахождения ближайшей пешки в колонке
    fun findClosestInColumn(x: Int, y: Int): Int {
        var count = 0
        val colPawns = cols[y] ?: return 0
        colPawns.sort()
        for (pawnX in colPawns) {
            if (pawnX < x || pawnX > x) count++
        }
        return count
    }

    // Функция для нахождения ближайшей пешки на диагонали
    fun findClosestInDiagonal(x: Int, y: Int): Int {
        var count = 0
        // y - x = const
        val diag1Pawns = diag1[y - x] ?: return 0
        diag1Pawns.sort()
        for (pawnX in diag1Pawns) {
            if (pawnX != x) count++
        }
        // y + x = const
        val diag2Pawns = diag2[y + x] ?: return 0
        diag2Pawns.sort()
        for (pawnX in diag2Pawns) {
            if (pawnX != x) count++
        }
        return count
    }

    // Обработка запросов
    for (i in 0 until Q) {
        val t = scanner.next()[0]
        val x = scanner.nextInt()
        val y = scanner.nextInt()

        when (t) {
            'K' -> println(countKnightAttacks(x, y))
            'P' -> println(countPawnAttacks(x, y))
            'R' -> {
                // Ладья атакует по строкам и столбцам
                println(findClosestInRow(x, y) + findClosestInColumn(x, y))
            }
            'B' -> {
                // Слон атакует по диагоналям
                println(findClosestInDiagonal(x, y))
            }
            'Q' -> {
                // Ферзь атакует как ладья и как слон
                println(findClosestInRow(x, y) + findClosestInColumn(x, y) + findClosestInDiagonal(x, y))
            }
        }
    }
}
