//https://leetcode.com/problems/count-and-say/
class CountAndSay {
    fun run() {
        println(countAndSay(3))
        println(countAndSay(4))
        println(countAndSay(5))
        println(countAndSay(6))
        println(countAndSay(7))
        println(countAndSay(8))
        println(countAndSay(9))
        println(countAndSay(10))
    }

    // TODO not the fastest solution. :(
    fun countAndSay(n: Int): String {
        if (n == 1) return "1"

        val prev = countAndSay(n - 1)

        val counts = ArrayList<Pair<Char, Int>>()
        var currentChar = prev[0]
        var currentCount = 0

        for (i in 0 until prev.length) {
            if (currentChar == prev[i]) {
                currentCount++
            } else {
                counts.add(Pair(currentChar, currentCount))
                currentCount = 1
            }
            currentChar = prev[i]
        }
        // add the last set
        counts.add(Pair(currentChar, currentCount))

        var current = ""
        counts.forEach { (num, count) ->
            current += "${count}${num}"
        }
        return current
    }
}