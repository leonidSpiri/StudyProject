package leetcode

fun main() {
    //println(removeDuplicateLetters("bcabc"))
}

private fun findTheDifference(s: String, t: String): Char {
    var newT = t
    s.forEach { sChar ->
        if (newT.contains(sChar)) newT = newT.replaceFirst(sChar.toString(), "")
    }
    return newT[0]
}


private fun removeDuplicateLetters(s: String) = buildString {
    val visited = mutableSetOf<Char>()
    val lastInds = mutableMapOf<Char, Int>()
    s.onEachIndexed { i, c -> lastInds[c] = i }
    s.onEachIndexed { i, c ->
        if (visited.add(c)) {
            while (isNotEmpty() && last() > c && i < lastInds[last()]!!)
                visited.remove(last()).also { setLength(lastIndex) }
            append(c)
        }
    }
}