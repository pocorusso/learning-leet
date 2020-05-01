import util.TreeNode

class BinaryTreeMaxPathSum {
    fun run() {
       // println(maxPathSum(TreeNode.Companion.build(arrayListOf(1,2,3))))
        println(maxPathSum(TreeNode.Companion.build(arrayListOf(-3))))
    }

    var max = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        traverse(root, max)
        return max
    }


    fun traverse(node: TreeNode?, sum: Int): Int {
        if (node == null) return 0
        val left = traverse(node.left, sum)
        val right = traverse(node.right, sum)

        val maxSub1 = Math.max(Math.max(left, right) + node.`val` , node.`val`)
        val maxSub2 = Math.max(maxSub1, left+right+node.`val`)

        max = Math.max(max, maxSub2)
        return maxSub1
    }
}