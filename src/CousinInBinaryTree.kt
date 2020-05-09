import util.TreeNode

class CousinInBinaryTree {
    fun run() {
        println(isCousins(TreeNode.Companion.build(arrayListOf(1, 2, 3, 4)), 3, 4))
        println(isCousins(TreeNode.Companion.build(arrayListOf(1, 2, 3, null, 4, null, 5)), 5, 4))
    }

    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        return (getLevel(root, x, 1) == getLevel(root, y, 1) && !isSameParent(root, x, y))
    }

    fun getLevel(current: TreeNode?, target: Int, level: Int): Int {
        if (current == null) return 0
        if (current.`val` == target) return level
        val leftLevel = getLevel(current.left, target, level + 1)
        if (leftLevel != 0) return leftLevel

        return getLevel(current.right, target, level + 1)
    }

    fun isSameParent(node: TreeNode?, x: Int, y: Int): Boolean {
        if (node == null) return false
        val left = node.left?.`val` ?: 0
        val right = node.right?.`val` ?: 0
        return ((left == x && right == y) ||
                (right == y && left == x) ||
                isSameParent(node.left, x, y) ||
                isSameParent(node.right, x, y))
    }

}