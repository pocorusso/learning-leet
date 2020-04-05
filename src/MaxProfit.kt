//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class MaxProfit {
    fun run() {
        println(maxProfit(intArrayOf(2, 1, 2, 0, 1))) //2
        println(maxProfit(intArrayOf(2, 1, 2, 1, 0, 0, 1))) //2
        println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))) //7
        println(maxProfit(intArrayOf(1, 2, 3, 4, 5))) //4
        println(maxProfit(intArrayOf(7, 6, 4, 3, 1))) //0
        println(maxProfit(intArrayOf(1, 2, 1, 2, 1, 2, 1, 2, 3))) //5

    }

    // Argh. Required thinking on a graph level.
    fun maxProfit(prices: IntArray): Int {
        var maxprofit = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1]
        }
        return maxprofit
    }

    /* o(n^2) solution that failed.
    /**
     * 1,5 - 3,6 3,4 -
     * 1,3 -
     * 1,6
     * 1,4
     *
     */
    fun maxProfit(prices: IntArray): Int {
        val candidates = mutableListOf<Candidate>()
        for (i in 0 until prices.size - 1) {
            for (j in i + 1 until prices.size) {
                if (prices[i] < prices[j]) {
                    candidates.add(Candidate(prices[j] - prices[i], i, j, "${prices[i]},${prices[j]}"))
                }
            }
        }

        maxProfit = 0
        findProfit(candidates, candidates.size, -1, 0)
        return maxProfit
    }

    var maxProfit = 0

    fun findProfit(
        filteredCandidates: List<Candidate>,
        numOfTotalCandidate: Int,
        previousSellIndex: Int,
        profit: Int
    ): Int {
        if (previousSellIndex > numOfTotalCandidate) return profit
        val filtered = filteredCandidates.filter { it.buy > previousSellIndex } //buyIndex > previousSellIndex
        var total = profit

        for (i in 0 until filtered.size) {
            total = findProfit(filtered, numOfTotalCandidate, filtered[i].sell, filtered[i].profit + profit)
            maxProfit = Math.max(maxProfit, total)
        }
        return total
    }

    data class Candidate(val profit: Int, val buy: Int, val sell: Int, val note: String)
    */

}