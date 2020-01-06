package util

// leetCode use 'val' as the list node value so we have to deal with it.
class ListNode(var `val`: Int) {
    var next: ListNode? = null

    companion object {
        fun createNodes(input: IntArray): ListNode {
            val head = ListNode(input[0])
            var current = head
            for (x in 1 until input.size) {
                val next = ListNode(input[x])
                current.next = next
                current = next
            }
            return head
        }
    }

    override fun toString(): String {
        var result = ""
        var current: ListNode? = this
        while (current != null) {
            val value = current.`val`
            result += "$value->"
            current = current.next
        }
        return result
    }
}



