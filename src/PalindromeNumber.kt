import kotlin.math.abs

//https://leetcode.com/problems/palindrome-number/
class PalindromeNumber {
    fun run() {
        println(isPalindrome(121))
        println(isPalindrome(-121))
        println(isPalindrome(10000000))
    }

    // O(n)
    fun isPalindrome(x: Int): Boolean {
        if (x in 1..9) return true
        if (x < 0) return false

        val length = x.length()
        var current = x
        val digits = arrayListOf<Int>()
        for (n in 1..length) {
            digits.add(current % 10)
            current /= 10
        }

        for (i in 0 until digits.size / 2) {
            if (digits[i] != digits[digits.size - 1 - i]) {
                return false
            }
        }
        return true;
    }

    fun Int.length() = when (this) {
        0 -> 1
        else -> Math.log10(abs(toDouble())).toInt() + 1
    }
}