class CheckIfStraightLine {
    fun run() {
//        println(
//            checkStraightLine(
//                arrayOf(
//                    intArrayOf(1, 2),
//                    intArrayOf(2, 3),
//                    intArrayOf(3, 4),
//                    intArrayOf(4, 5),
//                    intArrayOf(5, 6),
//                    intArrayOf(6, 7)
//                )
//            )
//        ) // true
//
//        println(
//            checkStraightLine(
//                arrayOf(
//                    intArrayOf(1, 1),
//                    intArrayOf(2, 2),
//                    intArrayOf(3, 4),
//                    intArrayOf(4, 5),
//                    intArrayOf(5, 6),
//                    intArrayOf(7, 7)
//                )
//            )
//        ) //false

        println(
            checkStraightLine(
                arrayOf(
                    intArrayOf(-3, -2),
                    intArrayOf(-1, -2),
                    intArrayOf(2, -2),
                    intArrayOf(-2, -2),
                    intArrayOf(0, -2)
                )
            )
        )
    }

    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        if(coordinates.size <= 2) return true
        val slope = getSlope(coordinates[1], coordinates[0])

        for (i in 2 until coordinates.size) {
            val testSlope = getSlope(coordinates[i], coordinates[i - 1])
            if (testSlope != slope) return false
        }
        return true
    }

    private fun getSlope(y: IntArray, x: IntArray): Float {
        if(y[0].toFloat() == x[0].toFloat()) return Float.MAX_VALUE //Vertical line
        return (y[1].toFloat() - x[1].toFloat()) / (y[0].toFloat() - x[0].toFloat())
    }
}