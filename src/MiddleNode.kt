import util.ListNode

class MiddleNode {
    fun run() {
        println(middleNode(ListNode.createNodes(intArrayOf(1, 2, 3, 4, 5))))
        println(middleNode(ListNode.createNodes(intArrayOf(1, 2, 3, 4, 5, 6))))
    }

    fun middleNode(head: ListNode?): ListNode? {
        var current = head
        var mid = head
        var count = 0
        while (current?.next != null) {
            current = current.next
            if (count % 2 == 0) {
                mid = mid?.next
            }
            count++
        }
        return mid
    }
}