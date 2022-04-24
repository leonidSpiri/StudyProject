import java.security.SecureRandom

fun main() {
    val random = SecureRandom()
    var sum: Long = 0
    val result = Array(10) { LongArray(5) }
    for (i in result.indices) {
        val seed = (i + 1) * 18
        println("Начальное число = $seed")
        for (j in 0..4) {
            val number = random.nextInt(400) - 200
            val res = number.toLong() * seed
            result[i][j] = res
            print(result[i][j].toString() + "\t")
            sum += result[i][j]
        }
        println()
    }
    println("Общая сумма = $sum")
}
