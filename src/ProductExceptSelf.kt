class ProductExceptSelf {
    fun run() {
        println(productExceptSelf(intArrayOf(1, 2, 3, 4)).toList())
        println(productExceptSelf(intArrayOf(1)).toList())
        println(productExceptSelf(intArrayOf()).toList())
        println(productExceptSelf(intArrayOf(1,1)).toList())
    }

    fun productExceptSelf(nums: IntArray): IntArray {
        if(nums.size == 1 || nums.isEmpty()) return nums

        val p1 = IntArray(nums.size)
        val p2 = IntArray(nums.size)
        val end = nums.size - 1
        p1[0] = nums[0]
        p2[end] = nums[end]
        for (i in 1..end) {
            p1[i] = p1[i - 1] * nums[i]
            p2[end - i] = p2[end - i + 1] * nums[end - i]
        }

        val results = IntArray(nums.size)
        results[0] = p2[1]
        results[end] = p1[end - 1]
        for (i in 1 until end) {
            results[i] = p1[i - 1] * p2[i + 1]
        }

        return results
    }
}