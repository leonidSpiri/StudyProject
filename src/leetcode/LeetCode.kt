package leetcode

import kotlin.math.min

private fun main() {
    //println(countHillsAndValleysInAnArray (intArrayOf(2, 4, 1, 1, 6, 5))) //1
    //println(divideArrayIntoEqualPairs(intArrayOf(3, 2, 3, 2, 2, 2, 2, 3))) //2
    //println(findTheDifferenceOfTwoArrays(intArrayOf(1, 2, 3, 3), intArrayOf(1, 1, 2, 2))) //3
    //println(minimumCostOfBuyingCandiesWithDiscount(intArrayOf(6, 5, 3, 4))) //4
    //println(countElementsWithStrictlySmallerAndGreaterElements(intArrayOf(-3, 3, 3, 90))) //5
    //println(twoSum(intArrayOf(3, 3), 6).contentToString()) //6
    //println(isPalindrome(11)) //7
    //mergeSortedArray(nums1 = intArrayOf(1, 2, 3, 0, 0, 0), m = 3, nums2 = intArrayOf(2, 5, 6), n = 3) //8
    //println(plusOne(intArrayOf(2, 3, 4, 9, 9, 8, 7, 9, 9)).contentToString()) //9
    //println(addBinary("1010", "1011")) //10
    //println(addTwoNumbers(intArrayOf(1,0), intArrayOf(9, 9, 9, 9)).contentToString()) //11
    //println(lengthOfLongestSubstring("asjrgapa")) //12
    //println(maxArea(intArrayOf(2, 3, 4, 5, 18, 17, 6))) //13
    //println(intToRoman(1994)) //14
    //println(romanToInt("MCMXCIV")) //15
    //println(isValidParentheses("[({()()()(){}{}{[][][]}})][")) //16
    //mergeTwoLists() //17
    //println(findTheIndexOfTheFirstOccurrenceInAString("mississippi", "issipi")) //18
    //println(findFirstAndLastPositionOfElementInSortedArray(intArrayOf(1, 2, 9), 9).contentToString()) //19
}

private fun countHillsAndValleysInAnArray(nums: IntArray): Int {
    /*You are given a 0-indexed integer array nums. An index i is part of a hill in nums if the closest non-equal neighbors of i are smaller than nums[i]. Similarly, an index i is part of a valley in nums if the closest non-equal neighbors of i are larger than nums[i]. Adjacent indices i and j are part of the same hill or valley if nums[i] == nums[j].
Note that for an index to be part of a hill or valley, it must have a non-equal neighbor on both the left and right of the index.
Return the number of hills and valleys in nums.*/
    if (nums.size < 3) return 0
    var res = 0
    for (i in 1 until nums.lastIndex) {
        val prev = nums[i - 1]
        var next = nums[i + 1]
        val real = nums[i]
        if (real == prev) continue
        if (real == next) {
            var newIndex = i + 1
            while (real == next) {
                if (newIndex <= nums.lastIndex) {
                    next = nums[newIndex]
                    newIndex++
                } else break
            }
        }
        if (real > next && real > prev) res++ //hill
        else if (real < next && real < prev) res++ //valley
    }
    return res
}

private fun divideArrayIntoEqualPairs(nums: IntArray): Boolean {
    /*You are given an integer array nums consisting of 2 * n integers. You need to divide nums into n pairs such that:
    Each element belongs to exactly one pair.
    The elements present in a pair are equal.
    Return true if nums can be divided into n pairs, otherwise return false.*/
    nums.sort()
    for (i in 0..nums.lastIndex step 2) {
        if (nums[i] != nums[i + 1]) return false
    }
    return true
}

private fun findTheDifferenceOfTwoArrays(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    /*Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
    answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
    Note that the integers in the lists may be returned in any order.*/
    val firstAnswer = mutableListOf<Int>()
    val secondAnswer = mutableListOf<Int>()

    nums1.forEach {
        if (!nums2.contains(it) && !firstAnswer.contains(it)) firstAnswer.add(it)
    }
    nums2.forEach {
        if (!nums1.contains(it) && !secondAnswer.contains(it)) secondAnswer.add(it)
    }
    return listOf(firstAnswer, secondAnswer)
}

private fun minimumCostOfBuyingCandiesWithDiscount(cost: IntArray): Int {
    /*A shop is selling candies at a discount. For every two candies sold, the shop gives a third candy for free.
    The customer can choose any candy to take away for free as long as the cost of the chosen candy is less than or equal to the minimum cost of the two candies bought.
    For example, if there are 4 candies with costs 1, 2, 3, and 4, and the customer buys candies with costs 2 and 3, they can take the candy with cost 1 for free, but not the candy with cost 4.
    Given a 0-indexed integer array cost, where cost[i] denotes the cost of the ith candy, return the minimum cost of buying all the candies.*/
    var result = 0
    cost.sortDescending()
    for (i in 0..cost.lastIndex step 3) {
        if ((i + 1) >= cost.size) return (result + cost[i])
        result += (cost[i] + cost[i + 1])
    }
    return result
}

private fun countElementsWithStrictlySmallerAndGreaterElements(nums: IntArray): Int {
    /*Given an integer array nums, return the number of elements that have both a strictly smaller and a strictly greater element appear in nums.*/
    if (nums.size < 3) return 0
    nums.sort()
    val buffArray = nums.toMutableList()
    val first = buffArray[0]
    while (buffArray[1] == first) {
        if (buffArray.size < 3) return 0
        buffArray.removeAt(0)
    }
    val last = buffArray.last()
    while (buffArray[buffArray.size - 2] == last) {
        if (buffArray.size < 3) return 0
        buffArray.removeAt(buffArray.lastIndex)
    }
    return (buffArray.size - 2)
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    /*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.*/
    if (nums.size < 2) return nums
    for (i in nums.indices) {
        for (j in i + 1..nums.lastIndex) {
            if (nums[i] + nums[j] == target) return intArrayOf(i, j)
        }
    }
    return intArrayOf()
}

private fun isPalindrome(x: Int): Boolean {
    //Given an integer x, return true if x is a palindrome, and false otherwise.
    val array = x.toString().split("").filter { it.isNotEmpty() }
    for (i in array.indices) {
        if (array[i] != array[array.lastIndex - i]) return false
    }
    return true
}

private fun mergeSortedArray(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    /*You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.*/
    for (i in 0 until n)
        nums1[m + i] = nums2[i]
    nums1.sort()
    println(nums1.contentToString())
}

private fun plusOne(digits: IntArray): IntArray {
    /*You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
    The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
    Increment the large integer by one and return the resulting array of digits.*/
    var goToNext = true
    var i = digits.lastIndex
    while (goToNext) {
        if (i < 0) {
            val l = mutableListOf(1)
            l.addAll(digits.toList())
            return l.toIntArray()
        }
        if (digits[i] != 9) {
            digits[i] = digits[i] + 1
            goToNext = false
        } else {
            digits[i] = 0
            i--
        }
    }
    return digits
}

private fun addBinary(a: String, b: String): String {
    //Given two binary strings a and b, return their sum as a binary string.
    val list1 = a.reversed().split("").filter { it.isNotEmpty() }
    val list2 = b.reversed().split("").filter { it.isNotEmpty() }
    val longerArraySize = if (list1.size > list2.size) list1.size else list2.size
    var pass = 0
    var result = ""
    for (i in 0 until longerArraySize) {
        val sum = getNextBinaryValueFromList(i, list1) + getNextBinaryValueFromList(i, list2) + pass
        pass = 0
        if (sum > 1) {
            pass = 1
            result += sum - 2
        } else {
            result += sum.toString()
        }
    }
    if (pass == 1) result += "1"
    return result.reversed()
}

private fun getNextBinaryValueFromList(i: Int, list: List<String>) =
    if (i <= list.lastIndex && list[i] == "1") 1 else 0

private fun getNextDecimalValueFromArray(i: Int, array: IntArray) = if (i < array.size) array[i] else 0

private fun addTwoNumbers(l1: IntArray, l2: IntArray): IntArray {
    val maxArrayValue = maxOf(l1.size, l2.size)
    val result = mutableListOf<Int>()
    var pass = 0
    for (i in 0 until maxArrayValue) {
        val count = getNextDecimalValueFromArray(i, l1) + getNextDecimalValueFromArray(i, l2) + pass
        pass = 0
        if (count > 9) {
            pass = 1
            result.add(count - 10)
        } else {
            result.add(count)
        }
    }
    if (pass == 1)
        result.add(1)

    return result.toIntArray()
}

private fun lengthOfLongestSubstring(s: String): Int {
    val buffList = linkedSetOf<Char>()
    var longestString = 0
    for (i in s.indices) {
        for (j in i..s.lastIndex) {
            if (!buffList.contains(s[j])) buffList.add(s[j])
            else {
                longestString = maxOf(longestString, buffList.size)
                buffList.clear()
                buffList.add(s[j])
            }
        }
        longestString = maxOf(longestString, buffList.size)
        buffList.clear()
    }
    return maxOf(longestString, buffList.size)
}

private fun maxArea(height: IntArray): Int {
    /*You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    Notice that you may not slant the container.*/
    var left = 0
    var right = height.lastIndex
    var maxResult = 0
    while (left != right) {
        val square = min(height[left], height[right]) * (right - left)
        maxResult = maxOf(maxResult, square)
        if (height[right] < height[left]) right--
        else left++
    }
    return maxResult
}

private fun intToRoman(num: Int): String {
    //Given an integer, convert it to a roman numeral.
    var digitClass = 1
    var newNum = num
    var result = ""
    while (newNum >= 1) {
        val workNum = (newNum % 10)
        when (digitClass) {
            1 -> {
                when {
                    workNum < 4 -> {
                        for (i in 1..workNum) result += "I"
                    }

                    workNum == 4 -> result = "IV"
                    workNum == 5 -> result = "V"
                    workNum < 9 -> {
                        result = "V"
                        for (i in 6..workNum) result += "I"
                    }

                    else -> result = "IX"

                }
            }

            10 -> {
                when {
                    workNum < 4 -> {
                        for (i in 1..workNum) result = "X${result}"
                    }

                    workNum == 4 -> result = "XL${result}"
                    workNum == 5 -> result = "L${result}"
                    workNum < 9 -> {
                        var buffStr = "L"
                        for (i in 6..workNum) buffStr += "X"
                        result = buffStr + result
                    }

                    else -> result = "XC${result}"

                }
            }

            100 -> {
                when {
                    workNum < 4 -> {
                        for (i in 1..workNum) result = "C${result}"
                    }

                    workNum == 4 -> result = "CD${result}"
                    workNum == 5 -> result = "D${result}"
                    workNum < 9 -> {
                        var buffStr = "D"
                        for (i in 6..workNum) buffStr += "C"
                        result = buffStr + result
                    }

                    else -> result = "CM${result}"
                }
            }

            1000 ->
                for (i in 1..workNum) result = "M${result}"
        }
        newNum /= 10
        digitClass *= 10
    }
    return result
}

private fun romanToInt(str: String): Int {
    //Given a roman numeral, convert it to an integer.
    val romanNumerals = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    var result = 0
    for (i in str.indices) {
        val workNum = romanNumerals.getValue(str[i])
        if ((i + 1) < str.length) {
            val nextNum = romanNumerals.getValue(str[i + 1])
            if (workNum < nextNum) result -= workNum
            else result += workNum
        } else result += workNum
    }

    return result
}

private fun isValidParentheses(s: String): Boolean {
    //Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    val stack = ArrayDeque<Char>()
    s.forEach {
        if (it == '(' || it == '{' || it == '[')
            stack.addLast(it)
        else
            when (it) {
                ')' -> if (stack.removeLastOrNull() != '(') return false
                '}' -> if (stack.removeLastOrNull() != '{') return false
                ']' -> if (stack.removeLastOrNull() != '[') return false
            }
    }

    return stack.isEmpty()
}

private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val result = ListNode(0)
    var l1 = list1
    var l2 = list2
    var current = result
    while (l1 != null && l2 != null) {
        if (l1.`val` < l2.`val`) {
            current.next = l1
            l1 = l1.next
        } else {
            current.next = l2
            l2 = l2.next
        }
        current = current.next!!
    }
    if (l1 != null) current.next = l1
    if (l2 != null) current.next = l2
    return result.next
}

private fun findTheIndexOfTheFirstOccurrenceInAString(haystack: String, needle: String): Int {
    //Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    if (needle.length > haystack.length) return -1
    if (needle == haystack) return 0
    var result: Int
    for (i in haystack.indices)
        if (haystack[i] == needle[0]) {
            result = i
            var isGood = true
            for (j in needle.indices)
                if ((i + j) >= haystack.length || haystack[i + j] != needle[j]) {
                    result = -1
                    isGood = false
                    break
                }
            if (isGood) return result

        }
    return -1
}

private fun findFirstAndLastPositionOfElementInSortedArray(nums: IntArray, target: Int): IntArray {
    /*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
    If target is not found in the array, return [-1, -1].
    You must write an algorithm with O(log n) runtime complexity.*/
    var start = -1
    var end = -1
    val lastIndex = nums.lastIndex
    for (i in nums.indices) {
        if (start == -1 && nums[i] == target) start = i

        if (end == -1 && nums[lastIndex - i] == target) end = lastIndex - i

        if (start != -1 && end != -1) return intArrayOf(start, end)
    }
    return intArrayOf(start, end)
}