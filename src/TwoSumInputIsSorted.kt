import java.util.*
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
class TwoSumInputIsSorted() {

    fun run() {
        var ans = twoSum(intArrayOf(2, 7, 11, 15), 9)
        println(ans.contentToString())

        ans = twoSum(intArrayOf(3,2,4), 6)
        println(ans.contentToString())
    }

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        // using look up O(n)
        val map = HashMap<Int, Int>()
        numbers.forEachIndexed { index, value -> map.put(value, index) }
        for (x in 0 until numbers.size - 1) {
            val index = map[target - numbers[x]]
            if(index!=null && index != x) return intArrayOf(x+1,index+1)
        }
        return intArrayOf()
    }
}