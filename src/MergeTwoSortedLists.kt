import util.ListNode

//https://leetcode.com/problems/merge-two-sorted-lists

class MergeTwoSortedLists {
    fun run() {
        println(mergeTwoLists(ListNode.createNodes(intArrayOf(1, 2, 4)), ListNode.createNodes(intArrayOf(1, 3, 4))))
        println(mergeTwoLists(null, ListNode.createNodes(intArrayOf(1))))
        println(mergeTwoLists(ListNode.createNodes(intArrayOf(2)), ListNode.createNodes(intArrayOf(1))))
        println(
            mergeTwoLists(
                ListNode.createNodes(intArrayOf(1, 1, 1, 1, 1, 1, 1)),
                ListNode.createNodes(intArrayOf(1, 3, 4))
            )
        )
        println(
            mergeTwoLists(
                ListNode.createNodes(intArrayOf(1, 1, 2, 4, 4, 8, 9)),
                ListNode.createNodes(intArrayOf(1, 2, 3, 4, 6, 7))
            )
        )

        println(mergeTwoLists(ListNode.createNodes(intArrayOf(2)), ListNode.createNodes(intArrayOf(1))))

    }

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1

        val dummy = ListNode(0)

        var m = dummy
        var c1 = l1
        var c2 = l2
        while (c1 != null && c2 != null) {
            val val1 = c1.`val`
            val val2 = c2.`val`
            when {
                val1 <= val2 -> {
                    m.next = ListNode(val1)
                    c1 = c1.next
                }
                val1 > val2 -> {
                    m.next = ListNode(val2)
                    c2 = c2.next
                }
            }
            m = m.next!!
        }

        if (c2 != null) m.next = c2
        if (c1 != null) m.next = c1

        return dummy.next
    }
}