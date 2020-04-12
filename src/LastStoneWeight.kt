import java.util.Collections
import java.util.PriorityQueue

class LastStoneWeight {
    fun run() {
        println(lastStoneWeight(intArrayOf(2, 2)))
        println(lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
        println(lastStoneWeight(intArrayOf(1)))
        println(lastStoneWeight(intArrayOf(1, 3, 3, 2, 1, 1, 1, 1, 1, 1)))
    }

    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        stones.forEach { pq.offer(it) }
        return smash(pq)
    }

    fun smash(stones: PriorityQueue<Int>): Int {
        if (stones.size == 0) return 0
        if (stones.size == 1) return stones.poll()

        val end1 = stones.poll()
        val end2 = stones.poll()
        val diff = end1 - end2

        if (diff > 0) stones.offer(diff)
        return smash(stones)
    }
}