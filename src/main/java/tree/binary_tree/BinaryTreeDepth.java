package tree.binary_tree;

import common.BinaryTreeNode;

public class BinaryTreeDepth {

    public static int solve(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        BinaryTreeNode left = node.getLeft();
        BinaryTreeNode right = node.getRight();
        if (left == null && right == null) {
            return 0;
        }
        int leftDepth = solve(left);
        int rightDepth = solve(right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
