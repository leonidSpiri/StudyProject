package pointless_attempts

fun countWord(str: String): Int {
    val target = "rumpelstiltskin"

    // Подсчитываем количество каждой буквы в целевом слове. В целом можно было забить сразу, если не предполагается что будем менять target
    val targetCount = mutableMapOf<Char, Int>()
    for (char in target)
        targetCount[char] = targetCount.getOrDefault(char, 0) + 1

    // Подсчитываем количество каждой буквы в данной строке
    val strCount = mutableMapOf<Char, Int>()
    for (char in str.lowercase())
        if (char.isLetter())
            strCount[char] = strCount.getOrDefault(char, 0) + 1

    // Находим минимальное количество раз, которым можно собрать слово
    var minCount = Int.MAX_VALUE
    for ((char, needed) in targetCount) {
        val available = strCount.getOrDefault(char, 0) //Ищем нужную для нас букву, иначе 0
        minCount = minOf(minCount, available / needed)
    }

    return if (minCount == Int.MAX_VALUE) 0 else minCount
}

fun main() {
    val str =
        "Rabbits under moonlight play, elves laugh, singing tales in late summer, kittens in nests.Rabbits under moonlight play, elves laugh, singing tales in late summer, kittens in nests.Rabbits under moonlight play, elves laugh, singing tales in late summer, kittens in nests."//readLine()!!
    println(countWord(str))
}