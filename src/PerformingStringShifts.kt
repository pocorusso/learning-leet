class PerformingStringShifts {
    fun run() {
        println(stringShift("abc", arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))))
        println(stringShift("abcdefg", arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(0, 2), intArrayOf(1, 3))))
        println(
            stringShift(
                "wpdhhcj", arrayOf(
                    intArrayOf(0, 7), intArrayOf(1, 7), intArrayOf(1, 0), intArrayOf(1, 3),
                    intArrayOf(0, 3), intArrayOf(0, 6), intArrayOf(1, 2)
                )
            )
        )
    }

    fun stringShift(s: String, shift: Array<IntArray>): String {
        var amount = 0
        shift.forEach {
            when (it[0]) {
                0 -> {
                    amount = amount - it[1]
                }
                1 -> {
                    amount = amount + it[1]
                }
            }
        }

        amount %= s.length
        return rotate(
            s.toCharArray()
            , if (amount < 0) s.length + amount else amount
        )
    }

    fun rotate(nums: CharArray, k: Int): String {
        var count = 0
        var start = 0
        while (count < nums.size) {
            var current = start
            var currentValue = nums[start]
            do {
                val posToMove = (current + k) % nums.size
                val previousValue = nums[posToMove]
                nums[posToMove] = currentValue

                current = posToMove
                currentValue = previousValue
                count++
            } while (start != current)

            start++
        }

        return nums.joinToString(separator = "")
    }
}