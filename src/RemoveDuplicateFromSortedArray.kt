//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class RemoveDuplicateFromSortedArray {
    fun run() {
        val arr1 = intArrayOf(1, 1, 2)
        println(removeDuplicates(arr1))
        println(arr1.toList())

        val arr2 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        println(removeDuplicates(arr2))
        println(arr2.toList())

        val arr3 = intArrayOf(1, 1, 1)
        println(removeDuplicates(arr3))
        println(arr3.toList())

        println(removeDuplicates(emptyArray<Int>().toIntArray()))
    }

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var uniqueCount = 0
        var prevVal = nums[0]
        for (i in 1 until nums.size) {
            if (prevVal != nums[i]) {
                nums[++uniqueCount] = nums[i]
            }
            prevVal = nums[i]
        }

        return uniqueCount + 1
    }
}