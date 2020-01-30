//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class FindFirstAndLastPosInSortedArray {
    fun run() {
        println(searchRange(intArrayOf(5, 7, 8), 7).toList())
        println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).toList())
        println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).toList())
        println(searchRange(intArrayOf(), 6).toList())
        println(searchRange(intArrayOf(1), 6).toList())
        println(searchRange(intArrayOf(6), 6).toList())
    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        return binarySearch(nums, 0, nums.size - 1, target)
    }

    private fun binarySearch(nums: IntArray, start: Int, end: Int, target: Int): IntArray {
        if (start > end) return intArrayOf(-1, -1)

        val mid = start + (end - start) / 2
        val midValue = nums[mid]
        return when {
            midValue == target -> {
                findRange(nums, mid, target)
            }
            midValue > target -> binarySearch(nums, start, mid - 1, target)
            else -> binarySearch(nums, mid + 1, end, target)
        }
    }

    private fun findRange(nums: IntArray, mid: Int, target: Int): IntArray {
        var end = mid
        for (i in mid + 1 until nums.size) {
            if (nums[i] == target) {
                end++
            } else break
        }
        var start = mid
        for (i in mid - 1 downTo 0) {
            if (nums[i] == target) {
                start--
            } else break
        }
        return intArrayOf(start, end)
    }
}