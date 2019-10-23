package tree.binary_tree;

import common.TreeNode;

public class BinaryTreeDepth {

    public static int solve(TreeNode node) {
        if (node == null) {
            return 0;
        }
        TreeNode left = node.getLeft();
        TreeNode right = node.getRight();
        if (left == null && right == null) {
            return 0;
        }
        int leftDepth = solve(left);
        int rightDepth = solve(right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
