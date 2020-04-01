class SingleNumber {
    fun run() {
        println(singleNumber(intArrayOf(2,2,1)))
        println(singleNumber(intArrayOf(4,2,1,2,1)))
    }

    // Yeah not using the XOR approach here. Feels like that's cheating
    fun singleNumber(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for(num in nums) {
            if(set.contains(num)) {
                set.remove(num)
            } else set.add(num)
        }
        return set.elementAt(0)
    }
}