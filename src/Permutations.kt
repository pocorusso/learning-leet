class Permutations {
    fun run() {
        println(permute(intArrayOf(1, 2, 3)))
    }

    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        generatePermutations(nums.toMutableList(), result, 0, nums.size - 1)
        return result
    }

    private fun generatePermutations(nums: MutableList<Int>, result: MutableList<List<Int>>, start: Int, end: Int) {
        if (start == end) {
            val copy = mutableListOf<Int>().apply { this.addAll(nums) }
            result.add(copy)
            return
        }
        for (i in start..end) {
            swap(nums, start, i) // swap the ith element
            generatePermutations(nums, result, start + 1, end)
            swap(nums, start, i) // restore for the next round
        }
    }

    private fun swap(nums: MutableList<Int>, i: Int, j: Int) {
        val old = nums[i]
        nums[i] = nums[j]
        nums[j] = old
    }
}