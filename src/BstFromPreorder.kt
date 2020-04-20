import util.TreeNode


class BstFromPreorder {
    fun run() {
        val node = bstFromPreorder(intArrayOf(8, 5, 1, 7, 10, 12))
        println(bstFromPreorder(intArrayOf(8, 5, 1, 7, 10, 12))) //[8,5,10,1,7,null,12]
    }

    fun bstFromPreorder(nodes: IntArray): TreeNode? =
        if (nodes.isNotEmpty()) helper(nodes, 0, nodes.size - 1) else null

    private fun helper(nodes: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) return null
        val node = TreeNode(nodes[start])
        var i = start
        while (i <= end) {
            if (nodes[i] > node.`val`) break
            i++
        }
        node.left = helper(nodes, start + 1, i - 1)
        node.right = helper(nodes, i, end)
        return node
    }
}