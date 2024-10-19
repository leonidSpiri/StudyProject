package pointless_attempts

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val allEmail = arrayListOf<String>()
    for (i in 0 until scanner.nextInt()) {
        val email = scanner.next()
        var newEmail = ""
        // login part
        for (i in 0..email.lastIndex) {
            if (email[i] == '@') break
            if (email[i] == '.') continue
            if (email[i] == '-') break
            newEmail += email[i].toString()
        }
        newEmail += "@"

        //domain part
        var findLastDot = true
        var newDomain = ""
        for (i in email.lastIndex downTo 0) {
            if (findLastDot && email[i] != '.') continue
            else {
                if (findLastDot && email[i] == '.') {
                    findLastDot = false
                    continue
                }
            }
            if (email[i] == '@') break
            newDomain += email[i].toString()
        }
        newDomain = newDomain.reversed()
        newEmail += newDomain
        if (!allEmail.contains(newEmail)) allEmail.add(newEmail)
    }
    println(allEmail.size)
}