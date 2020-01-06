import util.ListNode

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

class RemoveNthNodeFromEndOfList {
    fun run() {
        println(removeNthFromEnd(ListNode.createNodes(intArrayOf(1, 2, 3, 4, 5)), 2))
        println(removeNthFromEnd(ListNode.createNodes(intArrayOf(1, 2, 3, 4, 5)), 5))
        println(removeNthFromEnd(ListNode.createNodes(intArrayOf(1)), 1))
    }

    // N is always valid. no need to check size
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return null

        var current = head
        val list = arrayListOf<ListNode>()
        while (current != null) {
            list.add(current)
            current = current.next
        }

        val size = list.size
        var result: ListNode? = head
        val indexToRemove = size - n
        when {
            indexToRemove > 0 -> list[size - n - 1].next = list[size - n].next
            indexToRemove == 0 -> result = if (list.size > 1) list[1] else null
            indexToRemove < 0 -> result = null
        }
        return result
    }
}