import java.util.Arrays

class SortedSquares {
    fun run() {
        println(
            Arrays.toString((sortedSquares(
                intArrayOf(-4, -1, 0, 3, 10))
            ))
        )
    }

    fun sortedSquares(nums: IntArray): IntArray {
        //val sorted = nums.map { it * it }.sorted()
        return nums.map { it * it }.sorted().toIntArray()
    }
}