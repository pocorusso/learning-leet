class MoveZeroes {
    fun run() {
//        println(moveZeroes(intArrayOf(0, 1, 0, 3, 12)).toList())
//        println(moveZeroes(intArrayOf(0, 1, 0, 3, 12, 0, 0)).toList())
//        println(moveZeroes(intArrayOf(0, 0, 0)).toList())
//        println(moveZeroes(intArrayOf(1, 2, 2, 0, 0, 0)).toList())
//        println(moveZeroes(intArrayOf(1, 2, 2, 0, 0, 0,4)).toList())
        println(moveZeroes(intArrayOf(1)).toList())
        println(moveZeroes(intArrayOf(0)).toList())
    }

    fun moveZeroes(nums: IntArray): IntArray {
        var zIndex = -1
        for(j in 0 until nums.size) {
            if(nums[j] == 0) {
                zIndex = j
                break;
            }
        }

        // no zero. done already
        if(zIndex == -1) return nums

        for (i in 0 until nums.size) {
            if(nums[i] != 0 && i > zIndex) {
                nums[zIndex] = nums[i]
                nums[i] = 0
                zIndex++
            }
        }

        return nums
    }

    //    fun moveZeroes(nums: IntArray): IntArray {
//        var zIndex = nums.size - 1
//        for(j in nums.size-1 downTo 0) {
//            if(nums[j] != 0) {
//                zIndex = j
//                break;
//            }
//        }
//
//        for (i in 0 until nums.size) {
//            if(i > zIndex) break
//            if(nums[i] == 0) {
//                val temp = nums[i]
//                nums[i] = nums[zIndex]
//                nums[zIndex] = temp
//                zIndex--
//            }
//
//        }
//        return nums
//    }

}