class MissingNumber {

    fun run() {
        println(missingNumber(intArrayOf(3, 0, 1)))
        println(missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
        println(missingNumber(intArrayOf(3, 4, 2, 1)))
        println(missingNumber(intArrayOf(0,1)))
        println(missingNumber(intArrayOf(1)))
        println(missingNumber(intArrayOf(0)))
    }

    fun missingNumber(nums: IntArray): Int {
        if (nums.size == 1) {
            if (nums[0] == 0) return 1 else return 0
        }
        var max = Int.MIN_VALUE
        var total = 0
        var zeroExists = false
        for (num in nums) {
            if (num == 0) {
                zeroExists = true
            } else {
                if (num > max) max = num
                total += num
            }

        }

        if(!zeroExists) return 0
        val missing = (max * (max + 1) / 2) - total
        return if(missing == 0) max+1 else missing
    }
}