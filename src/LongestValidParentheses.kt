import java.util.ArrayDeque

//https://leetcode.com/problems/longest-valid-parentheses/
class LongestValidParentheses {
    fun run() {
        println("() -> " + longestValidParentheses("()"))
        println(")()()) -> " + longestValidParentheses(")()())"))
        println("(() -> " + longestValidParentheses("(()"))
        println("()(() ->" + longestValidParentheses("()(()"))

    }

    var count = 0
    var max = 0

    fun longestValidParentheses(s: String): Int {
        if (s.isEmpty() || s.length < 2) return 0
        count = 0
        max = 0
        val stack = ArrayDeque<Char>()
        for (i in 0 until s.length) {
            when (s[i]) {
                ')' -> popPushStack(stack, '(', ')')
                '}' -> popPushStack(stack, '{', '}')
                ']' -> popPushStack(stack, '[', ']')
                else -> stack.push(s[i])
            }
        }
        return max
    }


    private fun popPushStack(stack: ArrayDeque<Char>, matching: Char, current: Char) {
        if (!stack.isEmpty() && stack.first == matching) {
            stack.pop()
            count += 2
        } else {
            stack.push(current)
            count = 0
        }
        if (count > max) {
            max = count
        }
    }
}