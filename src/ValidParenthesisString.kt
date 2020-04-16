import java.util.ArrayDeque

//https://leetcode.com/problems/valid-parenthesis-string/discuss/582759/java-two-stacks-100
class ValidParenthesisString {
    fun run() {
        // println(checkValidString("()")) //true
        println(checkValidString("(*)")) //true
        println(checkValidString("(*))")) //true
        println(checkValidString("****"))
    }

    fun checkValidString(s: String): Boolean {
        if (s.isEmpty()) return true
        if (s.length == 1) return s[0] == '*'
        if (s[0] == ')') return false


        val stack1 = ArrayDeque<Int>()
        val stack2 = ArrayDeque<Int>()

        for (i in 0 until s.length) {
            when (s[i]) {
                '(' -> stack1.push(i)
                '*' -> stack2.push(i)
                ')' -> {
                    if (!stack1.isEmpty()) stack1.pop() else if (!stack2.isEmpty()) stack2.pop() else return false
                }
            }
        }

        while (!stack1.isEmpty()) {
            if (stack2.isEmpty()) {
                return false;
            } else {
                if (stack1.pop() > stack2.pop()) {
                    return false;
                }
            }
        }
        return true
    }
}