class SubarraySum {
    fun run() {
        //sum(i,j)=sum(0,j)-sum(0,i),
        println(subarraySum(intArrayOf(1, 1, 1), 2)) //2
        println(subarraySum(intArrayOf(1, 2, 3), 3)) //2  1,3,6
        println(subarraySum(intArrayOf(1, 2, 3, 4, 5), 3))//2  0,3,6,10,15
    }

    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        val sum = IntArray(nums.size + 1)
        for (i in 1 .. nums.size) sum[i] = sum[i - 1] + nums[i - 1]
        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size + 1) {
                if (sum[j] - sum[i] == k) count++
            }
        }
        return count
    }
}