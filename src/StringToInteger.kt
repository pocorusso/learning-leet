class StringToInteger {
    fun run() {
        println(myAtoi("+1"))
        println(myAtoi(".1"))
        println(myAtoi("-91283472332"))
        println(myAtoi("-42 thats right hhh 778"))
        println(myAtoi("no way -42 thats right hhh 778"))
    }

    fun myAtoi(str: String): Int {
        var numStarted = false
        var isNegative = false
        var strNumber = ""
        outer@ for (i in str.indices) {
            if (str[i] == ' ' && !numStarted) {
                continue //discard white char
            } else {
                when {
                    (str[i] == '-' || str[i] == '+') && !numStarted -> isNegative = str[i] == '-'
                    str[i].isDigit() -> {
                        strNumber += str[i]
                    }
                    else -> {
                        break@outer
                    }
                }
                numStarted = true
            }
        }
        return convert(strNumber, isNegative)
    }

    private fun convert(str: String, isNegative: Boolean): Int {
        var num = 0L
        for (i in str.indices) {
            val codePoint = str.codePointAt(i)
            if (codePoint in 48..57) {
                num = num * 10 + (codePoint - 48)
            } else {
                // Numerical exception
                return 0
            }

            // check limit
            if (isNegative && (-1 * num) <= Integer.MIN_VALUE) return Int.MIN_VALUE
            if (!isNegative && num >= Integer.MAX_VALUE) return Int.MAX_VALUE
        }
        return (if (isNegative) num * -1L else num).toInt()
    }

}