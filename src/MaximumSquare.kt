class MaximumSquare {
    fun run() {
        println(
            maximalSquare(
                arrayOf(
                    charArrayOf('0', '0', '0', '1'),
                    charArrayOf('1', '1', '0', '1'),
                    charArrayOf('1', '1', '1', '1'),
                    charArrayOf('0', '1', '1', '1'),
                    charArrayOf('0', '1', '1', '1')
                )
            ) //9
        )
        println(
            maximalSquare(
                arrayOf(
                    charArrayOf('0', '0', '0'),
                    charArrayOf('0', '0', '0'),
                    charArrayOf('0', '1', '0')
                )
            ) //1
        )
        println(
            maximalSquare(
                arrayOf(
                    charArrayOf('0', '1'),
                    charArrayOf('1', '0')
                )
            ) //1
        )
        println(
            maximalSquare(
                arrayOf(
                    charArrayOf('1')
                )
            ) //1
        )

        println(
            maximalSquare(
                arrayOf(
                    charArrayOf('0', '1')
                )
            ) //1
        )
        println(
            maximalSquare(
                arrayOf()
            ) //0
        )
        println(
            maximalSquare(
                arrayOf(
                    charArrayOf('0', '0'),
                    charArrayOf('0', '0')
                )
            ) //0
        )

        println(
            maximalSquare(
                arrayOf(
                    charArrayOf('1', '1'),
                    charArrayOf('1', '1'),
                    charArrayOf('1', '0')
                )
            ) //4
        )
        println(
            maximalSquare(
                arrayOf(
                    charArrayOf('1', '0', '1'),
                    charArrayOf('1', '1', '1'),
                    charArrayOf('1', '1', '1'),
                    charArrayOf('1', '1', '1')
                )
            ) //9
        )
        println(
            maximalSquare(
                arrayOf(
                    charArrayOf('1', '0', '1', '0', '0'),
                    charArrayOf('1', '0', '1', '1', '1'),
                    charArrayOf('1', '1', '1', '1', '1'),
                    charArrayOf('1', '0', '0', '1', '0')
                )
            ) //4
        )

        println(
            maximalSquare(
                arrayOf(
                    charArrayOf('0', '0', '0', '1'),
                    charArrayOf('1', '1', '0', '1'),
                    charArrayOf('1', '1', '1', '1'),
                    charArrayOf('0', '1', '1', '1'),
                    charArrayOf('0', '1', '1', '1')
                )
            ) //9
        )

        println(
            maximalSquare(
                arrayOf(
                    charArrayOf('1', '1', '1', '0', '0'),
                    charArrayOf('1', '1', '1', '0', '0'),
                    charArrayOf('1', '1', '1', '1', '1'),
                    charArrayOf('0', '1', '1', '1', '1'),
                    charArrayOf('0', '1', '1', '1', '1'),
                    charArrayOf('0', '1', '1', '1', '1')
                )
            ) //16
        )

    }


    fun maximalSquare(matrix: Array<CharArray>): Int {
        val rows = matrix.size
        val cols = if (rows > 0) matrix[0].size else 0
        val dp = Array(rows + 1) { IntArray(cols + 1) }
        var maxsqlen = 0
        for (i in 1..rows) {
            for (j in 1..cols) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(
                        Math.min(dp[i][j - 1], dp[i - 1][j]),
                        dp[i - 1][j - 1]
                    ) + 1
                    maxsqlen = Math.max(maxsqlen, dp[i][j])
                }
            }
        }
        return maxsqlen * maxsqlen
    }


//    fun maximalSquare(matrix: Array<CharArray>): Int {
//        if (matrix.size < 1) return 0
//        if (matrix[0].size < 1) return 0
//
//        val numOfColumns = matrix[0].size
//        val numOfRows = matrix.size
//        var max = 0
//
//        if (numOfRows == 1) {
//            for (i in 0 until numOfColumns) {
//                if (matrix[0][i] == '1') max = 1
//            }
//            return max
//        }
//
//        if (numOfColumns == 1) {
//            for (i in 0 until numOfRows) {
//                if (matrix[0][i] == '1') max = 1
//            }
//            return max
//        }
//
//        for (i in 0 until numOfRows) {
//            for (j in 0 until numOfColumns) {
//                if (i == 0 || j == 0) {
//                    if (max < 1 && matrix[i][j] == '1') max = Math.max(max, 1) //at least one
//                    continue
//                }
//
//                if (matrix[i][j] == '1' &&
//                    matrix[i - 1][j] != '0' &&
//                    matrix[i][j - 1] != '0' &&
//                    matrix[i - 1][j - 1] != '0'
//                ) {
//                    max = Math.max(max, 1) //at least 1
//                    val innerSize = matrix[i - 1][j - 1].toInt() - 48  //char 1 is code 49
//                    if (innerSize == 1) {
//                        matrix[i][j] = (innerSize + 1).toChar()
//                        max = Math.max(innerSize + 1, max)
//                    } else {
//                        //check outer square
//                        var count = 0
//                        for (k in 1..innerSize) {
//                            if (matrix[i - k][j] != '0' && matrix[i][j - k] != '0') {
//                                count++
//                            }
//                        }
//                        if (count > 0) {
//                            matrix[i][j] = (innerSize + count - 1 + 48).toChar()
//                            max = Math.max(innerSize + count - 1, max)
//                        }
//                    }
//                } else if (max < 1 && matrix[i][j] == '1') {
//                    max = Math.max(max, 1)
//                }
//            }
//        }
//        return if (max > 1) max * max else max
//    }
}