import java.util.Arrays

//https://leetcode.com/problems/rotate-array/

class RotateArray {
    fun run() {
        var nums = intArrayOf(1, 2, 3, 4, 5, 6)
        rotate(nums, 2)
        println(Arrays.toString(nums))

        nums = intArrayOf(1)
        rotate(nums, 0)
        println(Arrays.toString(nums))
    }

    // 5 6 1 2 3 4
    /**
     * 1 2 3 4 5 6
     * 1 2 1 4 5 6 . 3 start = 0, n 1
     * 1 2 1 4 3 6 . 5 n = 2
     * 5 2 1 4 3 6 . 1 start == current, n = 3
     * 5 2 1 2 3 6 . 4 start == 1, n = 3
     * 5 2 1 2 3 4 . 6 , n = 4
     * 5 6 1 2 3 4 . n = 5
     */
    fun rotate(nums: IntArray, k: Int): Unit {
        var count = 0
        var start = 0
        while (count < nums.size) {
            var current = start
            var currentValue = nums[start]
            do {
                val posToMove = (current + k) % nums.size
                val previousValue = nums[posToMove]
                nums[posToMove] = currentValue

                current = posToMove
                currentValue = previousValue
                count++
            } while (start != current)

            start++
        }
    }

//    private fun moveOne(nums: IntArray) {
//        var count = 0
//        var current = 0
//        var currentValue = nums[0]
//        while (count < nums.size) {
//            count++
//            val posToMove = (current + 1) % nums.size
//            val previousValue = nums[posToMove]
//            nums[posToMove] = currentValue
//
//            current = posToMove
//            currentValue = previousValue
//        }
//    }
}