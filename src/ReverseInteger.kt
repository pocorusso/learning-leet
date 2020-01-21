//https://leetcode.com/problems/reverse-integer/
class ReverseInteger {
    fun run() {
        println(reverse(-2147483648))
        println(reverse(-123))
        println(reverse(120))
    }

    fun reverse(x: Int): Int {
        val reversed = StringBuilder().append(Math.abs(x)).reverse().toString()

        var result = 0
        try {
            result = reversed.toInt() * (if (x < 0) -1 else 1)
        } catch (e: NumberFormatException) {
            // do nothing
        }

        return result


        /** Brute force
        if((x in 0..9) || (x > -10 && x<0))return x

        val isNeg = x < 0
        val value : Long = x.toLong() * (if (isNeg) -1 else 1)

        val valueChar = value.toString().toCharArray()
        val size = valueChar.size
        val reverseChar = CharArray(size)
        var isPrecedingZero = true
        for (i in (size - 1) downTo 0) {
        // once it is no longer preceding zero then we skip the check
        if (isPrecedingZero && valueChar[i] != '0') {
        isPrecedingZero = false

        }

        if (!isPrecedingZero)
        reverseChar[size - 1 - i] = valueChar[i]
        }

        val prefix = if (isNeg) "-" else ""
        var result = reverseChar.filter { it != '\u0000' }.joinToString(separator= "",prefix=prefix).toLong()
        try {
        Math.toIntExact(result)
        }catch(e: ArithmeticException){
        result = 0
        }

        return result.toInt()
         **/
    }
}