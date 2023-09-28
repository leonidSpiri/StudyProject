package leetcode

fun main() {
    print(sortArrayByParity(intArrayOf(3,1,2,4)).contentToString())
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

private fun decodeAtIndex(s: String, k: Int): String {
    var totalLength = 0L
    var resIndex = k.toLong()
    var lastIndex = s.lastIndex

    for (i in s.indices) {
        val currentChar = s[i]

        if (currentChar.isDigit()) {
            totalLength *= currentChar.digitToInt()
        } else {
            totalLength++

            if (totalLength == resIndex) {
                return currentChar.toString()
            }
        }

        if (totalLength >= resIndex) {
            lastIndex = i
            break
        }
    }

    for (i in (0..lastIndex).reversed()) {
        val currentChar = s[i]

        if (currentChar.isDigit()) {
            totalLength /= currentChar.digitToInt()
            resIndex %= totalLength
        } else {
            if (resIndex == 0L || resIndex == totalLength) {
                return currentChar.toString()
            }
            totalLength--
        }
    }

    return ""
}

private fun sortArrayByParity(nums: IntArray): IntArray {
    val res = mutableListOf(nums[0])
    for (i in 1 until nums.size) {
        if (nums[i] % 2 == 0) res.add(0, nums[i])
        else res.add(res.size, nums[i])
    }
    return res.toIntArray()
}

