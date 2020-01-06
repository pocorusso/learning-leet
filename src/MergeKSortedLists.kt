//https://leetcode.com/problems/merge-k-sorted-lists/
import util.ListNode

class MergeKSortedLists {
    fun run() {
        println(
            mergeKLists(
                arrayListOf<ListNode?>(
                    ListNode.createNodes(intArrayOf(1, 4, 5)),
                    ListNode.createNodes(intArrayOf(1, 3, 4)),
                    ListNode.createNodes(intArrayOf(2, 6))
                ).toTypedArray()
            )
        )

        println(
            mergeKLists(
                arrayListOf<ListNode?>(
                    ListNode.createNodes(intArrayOf(6,7,9)),
                    ListNode.createNodes(intArrayOf(1)),
                    ListNode.createNodes(intArrayOf(1,3,4,5))
                ).toTypedArray()
            )
        )
    }
}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val dummy = ListNode(0)
    var merged: ListNode = dummy

    do {
        var minValue = Integer.MAX_VALUE
        var minNode: ListNode? = null
        var minIndex = -1
        var numOfFinished = 0
        for (i in 0 until lists.size) {
            val current = lists[i]
            if (current == null) {
                numOfFinished++
                continue
            }

            if (current.`val` <= minValue) {
                minNode = current
                minValue = current.`val`
                minIndex = i
            }
        }
        //advance the max value found
        if (minIndex > -1) {
            lists[minIndex] = minNode?.next
            if (minNode != null) {
                merged.next = ListNode(minNode.`val`)
                merged = merged.next!!
            }
        }

    } while (numOfFinished < lists.size)

    return dummy.next
}