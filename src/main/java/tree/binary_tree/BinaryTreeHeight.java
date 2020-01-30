package tree.binary_tree;

import common.TreeNode;

public class BinaryTreeHeight<T> {

    public int solve(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        TreeNode<T> left = node.getLeft();
        TreeNode<T> right = node.getRight();
        if (left == null && right == null) {
            return 0;
        }
        int leftHeight = solve(left);
        int rightHeight = solve(right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
