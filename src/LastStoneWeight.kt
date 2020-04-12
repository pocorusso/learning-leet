class LastStoneWeight {
    fun run() {
        println(lastStoneWeight(intArrayOf(2, 2)))
        println(lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
        println(lastStoneWeight(intArrayOf(1)))
        println(lastStoneWeight(intArrayOf(1,3,3,2,1,1,1,1,1,1)))
    }

    fun lastStoneWeight(stones: IntArray): Int {
        return smash(stones.toMutableList())
    }

    fun smash(stones: MutableList<Int>) : Int {
        if (stones.size == 0) return 0
        if (stones.size == 1) return stones[0]

        stones.sort()
        val end = stones.size - 1
        val diff = stones[end] - stones[end - 1]
        stones.removeAt(end)
        if (diff == 0) stones.removeAt(end - 1) else stones[end - 1] = diff
        return smash(stones)
    }

}