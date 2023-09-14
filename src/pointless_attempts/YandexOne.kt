package pointless_attempts

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val count = scanner.nextInt()
    val stoka = scanner.next()
    var max = 0
    var position = 0
    for (i in 0 until count) {
        val buff = scanner.nextInt()
        if (buff >= max) {
            max = buff
            position = i
        }
    }
    println(stoka[position].toString())
}