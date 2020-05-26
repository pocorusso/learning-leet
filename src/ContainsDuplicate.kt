class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        nums.forEach { if(set.contains(it)) return true else set.add(it) }
        return false
    }
}