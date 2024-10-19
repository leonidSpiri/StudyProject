package pointless_attempts

var daysInMonth = emptyList<Int>()
fun main() {
    // Ввод данных
    val (N, L) = readln().split(" ").map { it.toInt() }
    daysInMonth = readln().split(" ").map { it.toInt() }

    // Ввод сегодняшней даты и дня недели
    val (d1, m1, y1, t1) = readln().split(" ").map { it.toInt() }

    // Ввод даты затмения
    val (d2, m2, y2) = readln().split(" ").map { it.toInt() }

    // Считаем количество дней от начала времени до обеих дат
    val days1 = totalDays(d1, m1, y1)
    val days2 = totalDays(d2, m2, y2)

    // Разница в днях между двумя датами
    val daysDifference = days2 - days1

    // Определяем день недели для затмения
    val dayOfWeek = ((t1 - 1 + daysDifference % L + L) % L + 1).toInt()

    // Выводим результат
    println(dayOfWeek)
}

// Функция для подсчета количества дней с начала года до данной даты
fun daysFromStartOfYear(d: Int, m: Int): Int {
    var days = 0
    for (month in 1 until m) {
        days += daysInMonth[month - 1]
    }
    days += d - 1
    return days
}

// Подсчет общего количества дней с начала "нулевого" года до указанной даты
fun totalDays(d: Int, m: Int, y: Int): Long {
    // Считаем количество дней за полные годы
    val fullYearsDays = (y - 1).toLong() * daysInMonth.sum()

    // Добавляем дни текущего года до указанной даты
    val currentYearDays = daysFromStartOfYear(d, m)

    return fullYearsDays + currentYearDays
}