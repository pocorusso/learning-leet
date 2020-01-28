class FindMinimumInSortedArray {
    fun run() {
        println(findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2)))
        println(findMin(intArrayOf(3, 4, 5, 1, 2)))
        println(findMin(intArrayOf(1)))
        println(findMin(intArrayOf(2, 1)))
        println(findMin(intArrayOf(1, 2)))
    }

    fun findMin(nums: IntArray): Int {
        return nums[findMin(nums, 0, nums.size - 1)]
    }

    fun findMin(nums: IntArray, start: Int, end: Int): Int {
        if (start > end) return -1
        if (start == end) return if (isInflection(nums, start)) start else -1

        val midIndex = start + (end - start) / 2
        val mid = nums[midIndex]

        return when {
            isInflection(nums, midIndex) -> midIndex
            mid < nums[end] -> // min must be on the right
                findMin(nums, start, midIndex - 1)
            else ->
                findMin(nums, midIndex + 1, end)
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