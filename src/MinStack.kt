import java.util.ArrayDeque

class MinStack() {
    private var currentMin = Int.MAX_VALUE
    private val stack = ArrayDeque<Node>()

    class Node(
        val value: Int = Int.MIN_VALUE,
        val min: Int = Int.MAX_VALUE
    )

    fun push(x: Int) {
        if (x < currentMin) currentMin = x
        stack.push(Node(x, currentMin))
    }

    fun pop() {
        stack.pop()
        if (!stack.isEmpty()) {
            currentMin = stack.first.min
        } else currentMin = Int.MAX_VALUE
    }

    fun top(): Int = stack.first.value

    fun getMin(): Int = currentMin
}


class TestMinStack() {
    fun run() {
//        val obj = MinStack()
//        obj.push(-2)
//        obj.push(0)
//        obj.push(-3)
//        println(obj.getMin())
//        obj.pop()
//        println(obj.top())
//        println(obj.getMin())

//        ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
//        [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
        val obj = MinStack()
        obj.push(2147483646)
        obj.push(2147483646)
        obj.push(2147483647)
        obj.top()
        obj.pop()
        obj.getMin()
        obj.pop()
        obj.getMin()
        obj.pop()
        obj.push(2147483647)
    }
}