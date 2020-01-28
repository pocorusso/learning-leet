//https://leetcode.com/problems/search-in-rotated-sorted-array/
class SearchInRotatedSortedArray {
    fun run() {
        println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
        println(search(intArrayOf(1, 2, 3, 4, 5, 7, 8), 7))
        println(search(intArrayOf(4,5,6,7,0,1,2), 3))
        println(search(intArrayOf(), 5))
        println(search(intArrayOf(3, 1), 3))
        println(search(intArrayOf(1, 3), 3))
    }

    fun search(nums: IntArray, target: Int): Int {
        val min = findMinIndex(nums, 0, nums.size - 1)
        return when {
            min < 0 -> -1 //in case of empty set
            target == nums[min] -> min
            target > nums[min] && target <= nums[nums.size - 1] -> {
                binarySearch(nums, min, nums.size - 1, target)
            }
            else -> {
                binarySearch(nums, 0, min, target)
            }
        }
    }

    private fun binarySearch(nums: IntArray, start: Int, end: Int, target: Int): Int {
        if (start > end) return -1

        val midIndex = start + (end - start) / 2
        val mid = nums[midIndex]

        return when {
            mid == target ->
                midIndex
            mid > target ->
                binarySearch(nums, start, midIndex - 1, target)
            else ->
                binarySearch(nums, midIndex + 1, end, target)
        }
    }

    private fun findMinIndex(nums: IntArray, start: Int, end: Int): Int {
        if (start > end) return -1
        if (start == end) return if (isInflection(nums, start)) start else -1

        val midIndex = start + (end - start) / 2
        val mid = nums[midIndex]

        return when {
            isInflection(nums, midIndex) -> midIndex
            mid < nums[end] -> // min must be on the right
                findMinIndex(nums, start, midIndex - 1)
            else ->
                findMinIndex(nums, midIndex + 1, end)
        }
    }

    private fun isInflection(nums: IntArray, mid: Int): Boolean {
        if (nums.size == 1) return true

        val left = if (mid == 0) nums.size - 1 else mid - 1
        val right = if (mid == nums.size - 1) 0 else mid + 1
        if (left == right) {
            //only when the size is 2 this can happen
            return nums[mid] < nums[right]
        }
        return nums[left] > nums[mid] && nums[left] > nums[right] && nums[right] > nums[mid]
    }
}