import util.TreeNode

class DiameterOfBinaryTree {
    fun run() {
        println(diameterOfBinaryTree(TreeNode.Companion.build(arrayListOf(1,2,3,4,5))))
        println(diameterOfBinaryTree(TreeNode.Companion.build(arrayListOf(2,3,4,5,6,7,8))))
        println(diameterOfBinaryTree(TreeNode.Companion.build(arrayListOf(1,2,3))))
    }
    var longestPath = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        longestPath = 1
        depth(root)
        return longestPath - 1
    }

    fun depth(node: TreeNode?): Int {
        if (node == null) return 0
        val left = depth(node.left)
        val right = depth(node.right)
        longestPath = Math.max(longestPath, left + right + 1)
        return Math.max(left, right) + 1
    }
}