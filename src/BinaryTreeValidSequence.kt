import util.TreeNode
import java.util.LinkedList
import java.util.Stack

class BinaryTreeValidSequence {

    fun run() {
        println(
            isValidSequence(
                TreeNode.Companion.build(arrayListOf(0,1,2,3,4,5)),
                intArrayOf(0,1,3)
            )
        )
    }

    fun isValidSequence(root: TreeNode?, arr: IntArray): Boolean {
        return checkPath(root, arr.joinToString(separator = ""),"")
    }

    fun checkPath(root: TreeNode?, arr: String, curr: String) : Boolean {
       if(root == null) return false//base
        val temp = curr + root.`val`
        if(checkPath(root.left, arr, temp)) return true
        if(checkPath(root.right, arr, temp)) return true
        if(root.left == null && root.right == null) if(arr == temp) return true

        return false
    }
}