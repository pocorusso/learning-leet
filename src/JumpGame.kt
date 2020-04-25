class JumpGame {
    fun run() {
        println(canJump(intArrayOf(2, 3, 1, 1, 4))) //true
        println(canJump(intArrayOf(3, 2, 1, 0, 4))) //false
    }

//    fun canJump(nums: IntArray): Boolean {
//        var max = 0
//        var curr = 0
//        for (i in 0 until nums.size) {
//            curr = i
//            if (i >= max) break
//            max = Math.max(max, i + nums[i])
//        }
//        return curr == nums.size
//    }

    fun canJump(nums: IntArray): Boolean {
        var max = 0
        val length = nums.size
        var i = 0
        while (i < length && i <= max) {
            if (i + nums.get(i) > max) {
                max = i + nums.get(i)
            }
            i++
        }

        return i == length
    }

}