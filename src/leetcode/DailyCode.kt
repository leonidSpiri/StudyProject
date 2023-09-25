package leetcode

private fun findTheDifference(s: String, t: String): Char {
    var newT = t
    s.forEach { sChar ->
        if (newT.contains(sChar)) newT = newT.replaceFirst(sChar.toString(), "")
    }
    return newT[0]
}