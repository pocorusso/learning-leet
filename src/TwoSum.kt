import java.util.*
//https://leetcode.com/problems/two-sum/
class TwoSum() {
    /*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:
    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
    */

    fun run() {
        var ans = twoSum(intArrayOf(2, 7, 11, 15), 9)
        println(ans.contentToString())

        ans = twoSum(intArrayOf(3,2,4), 6)
        println(ans.contentToString())
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        // Brute force
        // O(n^2)
//        for (x in 0 until nums.size-1){
//            for(y in x+1 until nums.size-1){
//                if ((nums[x] + nums[y]) == target)
//                    return intArrayOf(x,y)
//            }
//        }
//        return intArrayOf()

        // using look up O(n)
        val map = HashMap<Int, Int>()
        nums.forEachIndexed { index, value -> map.put(value, index) }
        for (x in 0 until nums.size - 1) {
            val index = map[target - nums[x]]
            if(index!=null && index != x) return intArrayOf(x,index)
        }
        return intArrayOf()
    }
}