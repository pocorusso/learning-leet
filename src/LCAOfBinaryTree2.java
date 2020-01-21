import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LCAOfBinaryTree2 {
    public void run() {

        ArrayList<Integer> intArray = new ArrayList<>(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        TreeNode root = TreeNode.Companion.build(intArray);
        if (root != null) {
            System.out.println(root.toString());
        }
        TreeNode result = lowestCommonAncestor(root, new TreeNode(5, null, null), new TreeNode(1, null, null));
        System.out.println(result.getVal());
    }
    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        return result;
    }

    public boolean traverse(TreeNode current, TreeNode p, TreeNode q) {
        if (current == null) {
            return false;
        }

        int left = traverse(current.getLeft(), p, q) ? 1 : 0;
        int right = traverse(current.getRight(), p, q) ? 1 : 0;
        int mid = (current.getVal() == p.getVal() || current.getVal() == q.getVal()) ? 1 : 0;

        if(mid + left + right >= 2) {
            result = current;
        }

        return (mid + left + right) > 0;
    }
}
