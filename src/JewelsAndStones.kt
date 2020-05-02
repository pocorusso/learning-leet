class JewelsAndStones {
    fun run() {}

    fun numJewelsInStones(J: String, S: String): Int {
        val set = J.toHashSet()
        var count = 0
        S.forEach { if (set.contains(it)) count++ }
        return count
    }
}