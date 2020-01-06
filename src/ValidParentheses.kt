import java.util.ArrayDeque

class ValidParentheses {
    fun run() {
        println("() -> " + isValid("()"))
        println("()[]{} -> " + isValid("()[]{}"))
        println("(] -> " + isValid("(]"))
        println("([}] -> " + isValid("([}] "))
        println("{[]} -> " + isValid("{[]}"))
        println(" -> " + isValid(""))
        println("] -> " + isValid("]"))
        println("){ -> " + isValid("){"))
        println("(]) -> " + isValid("(])"))
        println("[]) -> " + isValid("[])"))
    }

    fun isValid(s: String): Boolean {
        if (s.isEmpty()) return true
        if (s.length == 1) return false
        if (s[0] == ')' || s[0] == '}' || s[0] == ']') return false

        val stack = ArrayDeque<Char>()

        for (i in 0 until s.length) {
            when (s[i]) {
                ')' -> popPushStack(stack, '(', ')' )
                '}' -> popPushStack(stack, '{', '}' )
                ']' -> popPushStack(stack, '[', ']' )
                else -> stack.push(s[i])
            }
        }
        return stack.isEmpty()
    }

    private fun popPushStack(stack: ArrayDeque<Char>, matching: Char, current: Char) {
        if (!stack.isEmpty() && stack.first == matching) stack.pop() else stack.push(current)
    }
}