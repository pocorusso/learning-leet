class HappyNumber {
    fun run() {
        println(isHappy(19))
        println(isHappy(1))
        println(isHappy(191))
    }


    fun isHappy(n: Int): Boolean {
        var sum = n
        val set = mutableSetOf<Int>()
        while (true) {
            sum = squareSum(getDigits(sum))
            if (set.contains(sum) || sum == 1) break
            set.add(sum)
        }
        return sum == 1
    }

    private fun squareSum(digits: List<Int>): Int {
        var sum = 0
        digits.forEach { sum += it * it }
        return sum
    }

    private fun getDigits(n: Int): List<Int> {
        val nStr = n.toString().split("")
        val retval = mutableListOf<Int>()
        for (element in nStr) {
            if (element.isNotEmpty()) retval.add(element.toInt())
        }
        return retval
    }
    
}