class BrokenCalculator {
    fun run() {
        println(brokenCalc(2, 3))
        println(brokenCalc(5, 8))
        println(brokenCalc(3, 10))
        println(brokenCalc(1024, 1))
    }

    fun brokenCalc(X: Int, Y: Int): Int {

        var numOfOps = 0
        var y = Y
        while (y > X) {
            numOfOps++
            if (y % 2 == 1) { //odd
                y++
            } else {
                y /= 2
            }
        }

        return numOfOps + X - y
    }
}