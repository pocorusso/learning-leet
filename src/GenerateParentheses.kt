import java.util.ArrayDeque

class GenerateParentheses {
    fun run() {
        println(generateParenthesis(1))
        println(generateParenthesis(3))
        println(generateParenthesis(5))
    }

    fun generateParenthesis(n: Int): List<String> {
        val result = ArrayList<String>()
        generateCombo(n * 2, result, 1, "(", 1)
        generateCombo(n * 2, result, 1, ")", -1)
        return result
    }

    private fun generateCombo(numOfParam: Int, result: MutableList<String>, depth: Int, current: String, balance: Int) {
        if (depth == numOfParam) {
            if (isValid(current)) {
                result.add(current)
            }
            return
        }

        if (balance > numOfParam / 2
            || balance < (-1 * numOfParam / 2)
        ) {
            //too many param to be ever valid skip the rest
            return
        }

        generateCombo(numOfParam, result, depth + 1, current + "(", balance + 1)
        generateCombo(numOfParam, result, depth + 1, current + ")", balance - 1)
    }

    fun isValid(s: String): Boolean {
        if (s.isEmpty()) return true
        if (s.length == 1) return false
        if (s[0] == ')' || s[0] == '}' || s[0] == ']') return false

        val stack = ArrayDeque<Char>()

        for (i in 0 until s.length) {
            when (s[i]) {
                ')' -> popPushStack(stack, '(', ')')
                else -> stack.push(s[i])
            }
        }
        return stack.isEmpty()
    }

    private fun popPushStack(stack: ArrayDeque<Char>, matching: Char, current: Char) {
        if (!stack.isEmpty() && stack.first == matching) stack.pop() else stack.push(current)
    }
}