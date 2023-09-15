package leetcode

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