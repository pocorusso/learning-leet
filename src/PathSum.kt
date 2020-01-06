import util.TreeNode

//https://leetcode.com/problems/path-sum/

class PathSum {

    val test1 =
        TreeNode(5).apply {
            left = TreeNode(4).apply {
                left = TreeNode(11).apply {
                    left = TreeNode(7)
                    right = TreeNode(2)
                }
            }
            right = TreeNode(8).apply {
                left = TreeNode(13)
                right = TreeNode(4).apply {
                    right = TreeNode(1)
                }
            }
        }

    val test2 = TreeNode(1).apply { left = TreeNode(2) }


    fun run() {
        println(hasPathSum(test1, 26))
        println(hasPathSum(test2, 1))
    }

    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if(root == null) return false
        return traverseFind(root, sum, 0)
    }

    fun traverseFind(node: TreeNode, sumToCheck: Int, partial: Int): Boolean {
        val partial = partial + node.`val`
        if (node.left == null && node.right == null) {
            return partial == sumToCheck
        }

        var foundLeft: Boolean = false
        var foundRight: Boolean = false
        if(node.left != null) foundLeft = traverseFind(node.left!!, sumToCheck, partial)
        if(node.right!= null) foundRight = traverseFind(node.right!!, sumToCheck, partial)

        return  foundLeft || foundRight
    }
}