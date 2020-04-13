//https://leetcode.com/problems/contiguous-array/
class ContiguousArray {
    fun run() {
        println(findMaxLength(intArrayOf(0, 1)))
        println(findMaxLength(intArrayOf(0, 1, 0)))
        println(findMaxLength(intArrayOf(1, 1, 0)))
        println(findMaxLength(intArrayOf(0, 0, 0, 0, 1, 1)))
    }

    fun findMaxLength(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        map.put(0, -1)
        var max = 0
        var sum = 0
        for (i in 0 until nums.size) {
            if (nums[i] == 0) sum-- else sum++
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum)!!)
            } else map.put(sum, i)
        }

        return max
    }
}