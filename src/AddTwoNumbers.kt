import util.ListNode

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
class AddTwoNumbers {

    fun run() {
        val ans = addTwoNumbers(ListNode.createNodes(intArrayOf(2,4,3)), ListNode.createNodes(intArrayOf(5,6,4)))
        //val ans = addTwoNumbers(createNodes(intArrayOf(9)), createNodes(intArrayOf(1, 9,9,9,9,9,9,9,9,9)))
        println(ans)
    }

    private var current1: ListNode? = null
    private var current2: ListNode? = null

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        current1 = l1
        current2 = l2
        val (initValue, initCarryOver) = getSum(0)
        var carryOver = initCarryOver

        val sumHead = ListNode(initValue)
        var sumCurrent = sumHead

        while (current1 != null || current2 != null) {
            val (sum, sumCarryOver) = getSum(carryOver)
            carryOver = sumCarryOver
            val sumNext = ListNode(sum)
            sumCurrent.next = sumNext
            sumCurrent = sumNext
        }

        if (carryOver == 1) {
            val sumNext = ListNode(1)
            sumCurrent.next = sumNext
        }

        return sumHead
    }

    private fun getSum(carryOver: Int) : Pair<Int, Int> {
        var sum = (current1?.`val` ?: 0) + (current2?.`val` ?: 0) + carryOver
        val sumCarryOver = if (sum > 9) {
            sum -= 10
            1
        } else 0
        current1 = current1?.next
        current2 = current2?.next

        return Pair(sum, sumCarryOver)
    }

    /* Wrong approach for large numbers over MAX INT and MAX LONG
    fun addTwoNumbers(l1: util.ListNode?, l2: util.ListNode?): util.ListNode? {
        if (l1 == null || l2 == null) return null
        val sum = getNumber(l1) + getNumber(l2)
        val sumCharArray = sum.toString().toCharArray()
        var head: util.ListNode? = null
        if (sumCharArray.isNotEmpty()) {
            head = util.ListNode(sumCharArray[sumCharArray.size - 1].toString().toInt())
            var current = head
            if (sumCharArray.size > 1) {
                for (i in sumCharArray.size - 2 downTo 0) {
                    val next = util.ListNode(sumCharArray[i].toString().toInt())
                    current!!.next = next
                    current = next
                }
            }
        }
        return head
    }

    private fun getNumber(node: util.ListNode): Long {
        var total = 0L
        var places = 0

        var current: util.ListNode? = node
        while (current != null) {
            total += (powerOf(places) * current.value)
            places++
            val next = current.next
            current = next
        }
        return total
    }

    /**
     * 10 ^ 0 = 1
     * 10 ^ 1 = 10
     * 10 ^ 2 = 100
     */
    fun powerOf(value: Int): Long {
        var result = 1L
        if (value > 0) {
            for (x in 1..value) {
                result *= 10L
            }
        }
        return result
    }
    */
}