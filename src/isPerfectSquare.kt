class isPerfectSquare {
    fun run() {

        println(isPerfectSquare(808201))//true
        println(isPerfectSquare(9))//true
        println(isPerfectSquare(16))//true
        println(isPerfectSquare(14))//false
        println(isPerfectSquare(9))//true
    }

    fun isPerfectSquare(num: Int): Boolean {
        if(num == 1) return true
        var low = 0
        var high = num
        var mid = 0
        for (i in 0..10000) {
            mid = (high - low) / 2 + low
            if (mid == 0) return false
            val square = mid*mid
            when {
                willOverflow(mid.toLong()) -> high = mid
                square == num -> return true
                square > num -> high = mid
                else -> low = mid
            }
        }
        return false
    }
    fun willOverflow(x:Long) : Boolean =
        x*x > Int.MAX_VALUE

}