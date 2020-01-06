package util

import java.util.LinkedList
import java.util.Queue

class TreeNode(
    var `val`: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
) {
    companion object {
        public fun build(nodes: ArrayList<Int?>): TreeNode? =
            if (nodes[0] != null) insertLevelOrder(nodes, TreeNode(nodes[0]!!), 0) else null


        private fun insertLevelOrder(nodes: ArrayList<Int?>, root: TreeNode?, index: Int): TreeNode? {
            var temp = root
            if (index < nodes.size && nodes[index] != null) {
                temp = TreeNode(nodes[index]!!)
                temp.left = insertLevelOrder(nodes, temp.left, 2 * index + 1)
                temp.right = insertLevelOrder(nodes, temp.right, 2 * index + 2)
            }
            return temp
        }
    }

    override fun toString(): String {
        return breathFirst(this)
    }

    private fun inOrder(root: TreeNode?): String {
        var result = ""
        root?.let {
            result += inOrder(it.left)
            result += "${it.`val`} "
            result += inOrder(it.right)
        }
        return result
    }

    private fun preOrder(root: TreeNode?): String {
        var result = ""
        root?.let {
            result += "${it.`val`} "
            result += preOrder(it.left)
            result += preOrder(it.right)
        }
        return result
    }

    private fun breathFirst(root: TreeNode): String {
        val queue = LinkedList<TreeNode>();
        var result = ""
        queue.add(root)
        while (queue.isNotEmpty()) {
            val tempNode = queue.poll()
            result += "${tempNode.`val`} "
            tempNode.left?.let{
                queue.add(it)
            }

            tempNode.right?.let{
                queue.add(it)
            }
        }
        return result
    }
}