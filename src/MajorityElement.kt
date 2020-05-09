class MajorityElement {
    fun run() {
        println(majorityElement(intArrayOf(3,2,3))) //3
        println(majorityElement(intArrayOf(2,2,1,1,1,2,2))) // 2
    }

    fun majorityElement(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        nums.forEach {
            val count = map.getOrDefault(it, 0)
            if (count == nums.size / 2) return it
            map.put(it, count + 1)
        }
        return -1
    }
}