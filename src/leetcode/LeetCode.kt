package leetcode

private fun main() {
    countHillsAndValleysInAnArray(intArrayOf(2, 4, 1, 1, 6, 5)).let {
        println(it)
    }
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
