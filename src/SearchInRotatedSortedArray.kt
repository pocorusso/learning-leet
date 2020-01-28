//https://leetcode.com/problems/search-in-rotated-sorted-array/
class SearchInRotatedSortedArray {
    fun run() {
        println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
        println(search(intArrayOf(1, 2, 3, 4, 5, 7, 8), 7))
    }

    fun search(nums: IntArray, target: Int): Int {
        return binarySearch(nums, 0, nums.size - 1, target)
    }

    fun binarySearch(nums: IntArray, start: Int, end: Int, target: Int): Int {
        if (start > end) return -1
        if (start == end) return if (nums[start] == target) start else -1

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

    fun findMin(nums: IntArray, start: Int, end: Int, target: Int): Int {
        if (start > end) return -1
        if (start == end) return if (nums[start] == target) start else -1

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
}