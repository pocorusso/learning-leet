import java.util.ArrayDeque

//https://leetcode.com/problems/longest-valid-parentheses/
class LongestValidParentheses {
    fun run() {
        println("(()))())( -> " + longestValidParentheses("(()))())("))
        println(")()()) -> " + longestValidParentheses(")()())"))
        println("(() -> " + longestValidParentheses("(()"))
        println("()(() ->" + longestValidParentheses("()(()"))
    }

    fun longestValidParentheses(s: String): Int {
        if (s.isEmpty() || s.length < 2) return 0

        var left = 0
        var right = 0
        var maxLen = 0
        for (i in 0 until s.length) {
            if (s[i].equals('(')) left++ else right++

            if (left == right) {
                maxLen = Math.max(maxLen, left + right)
            } else if (right >= left) {
                right = 0
                left = 0
            }
        }

        left = 0
        right = 0
        for (i in s.length - 1 downTo 0) {
            if (s[i].equals(')')) right++ else left++

            if (left == right) {
                maxLen = Math.max(maxLen, left + right)
            } else if (left >= right) {
                right = 0
                left = 0
            }
        }
        return maxLen
    }

    // Brute force
//    fun longestValidParentheses(s: String): Int {
//        if (s.isEmpty() || s.length < 2) return 0
//        var maxLen = 0
//
//        //brute force
//        for (i in 0 until s.length) {
//            for (j in i + 2 until s.length + 1 step 2) {
//                if (isValid(s.substring(i, j))) {
//                    maxLen = Math.max(maxLen, j - i)
//                }
//            }
//        }
//        return maxLen
//    }
//
//    fun isValid(s: String): Boolean {
//        if (s.isEmpty()) return true
//        if (s.length == 1) return false
//        if (s[0] == ')') return false
//        if (s[s.length - 1] == '(') return false
//
//        val stack = ArrayDeque<Char>()
//
//        for (i in 0 until s.length) {
//            when (s[i]) {
//                ')' -> popPushStack(stack, '(', ')')
//                else -> stack.push(s[i])
//            }
//        }
//        return stack.isEmpty()
//    }
//
//    private fun popPushStack(stack: ArrayDeque<Char>, matching: Char, current: Char) {
//        if (!stack.isEmpty() && stack.first == matching) stack.pop() else stack.push(current)
//    }
}