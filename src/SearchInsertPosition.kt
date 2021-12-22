class SearchInsertPosition {
    fun run() {
      //  println(searchInsert(intArrayOf(1,3,5,6), 5)) //2
        println(searchInsert(intArrayOf(1,3,5,6), 2)) //1
        println(searchInsert(intArrayOf(1,3,5,6), 7)) //4
        println(searchInsert(intArrayOf(1,3,5,7), 4)) //2
        println(searchInsert(intArrayOf(1,3,5,7,10), 9)) //4
    }

    fun searchInsert(nums: IntArray, target: Int): Int {
        var max = nums.size - 1
        var min = 0

        if(target>nums[max]) return max+1
        if(target<nums[0]) return 0

        while (min <= max) {
            val mid = ((max - min) / 2) + min
            when {
                target == nums[mid] -> return mid
                target > nums[mid] -> {
                    min = mid + 1
                }
                target < nums[mid] -> {
                    if(target > nums[mid-1]) return mid
                    max = mid - 1
                }
            }
        }
        return -1
    }
}