import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCAOfBinaryTree {
    public void run() {

        ArrayList<Integer> intArray = new ArrayList<>(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        TreeNode root = TreeNode.Companion.build(intArray);
        if (root != null) {
            System.out.println(root.toString());
        }

        System.out.println(lowestCommonAncestor(root, new TreeNode(5, null, null), new TreeNode(4, null, null)));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        findPath(root, p.getVal(), path1);
        findPath(root, q.getVal(), path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); ++i) {
            if (path1.get(i).getVal() != path2.get(i).getVal()) {
                break;
            }
        }
        return path1.get(i - 1);
    }

    private boolean findPath(TreeNode root, int n, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.getVal() == n) {
            return true;
        }

        if (root.getLeft() != null && findPath(root.getLeft(), n, path)) {
            return true;
        }

        if (root.getRight() != null && findPath(root.getRight(), n, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    /*
    private boolean preOrder(TreeNode root, Set<TreeNode> ancestors, Integer target, boolean isFound) {
        if (root != null && !isFound) {
            ancestors.add(root);
            if (root.getVal() != target) {
                isFound = preOrder(root.getLeft(), ancestors, target, isFound);
                isFound = preOrder(root.getRight(), ancestors, target, isFound);
            } else isFound = true;
        }
        return isFound;
    }

    private void breathFirst(TreeNode root, Set<TreeNode> ancestors, Integer target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            ancestors.add(tempNode);
            if (tempNode.getVal() == target) {
                break;
            }

            TreeNode left = tempNode.getLeft();
            TreeNode right = tempNode.getRight();
            boolean leftIsFound = false;
            if (left != null) {
                if(left.getVal() == target) {
                    leftIsFound = true;
                }
                queue.add(tempNode.getLeft());
            }

            if (right != null && !leftIsFound) {
                if(right.getVal() == target) {
                    // if the right node is the value, then we dont need to go down to the left sub tree any more.
                    queue.poll();
                }
                queue.add(tempNode.getRight());
            }

        }
    }
     */
}
