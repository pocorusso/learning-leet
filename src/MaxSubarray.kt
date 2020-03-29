//https://leetcode.com/problems/maximum-subarray/
class MaxSubarray {
    fun run() {
        println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
        println(maxSubArray(intArrayOf(-2, 1)))
    }

    fun maxSubArray(nums: IntArray): Int {
        var maxSum = Int.MIN_VALUE
        var sum = 0
        for (num in nums) {
            sum = Math.max(num, sum+num)
            maxSum = Math.max(sum, maxSum)
        }
        return maxSum
    }
}