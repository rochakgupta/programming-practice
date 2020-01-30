package tree.binary_tree;

import common.Pair;
import common.TreeNode;

public class BinaryTreeDiameter<T> {

    public int solve(TreeNode<T> root) {
        Pair<Integer, Integer> pair = helper(root);
        return pair.getSecond();
    }

    private Pair<Integer, Integer> helper(TreeNode<T> node) {
        if (node == null) {
            return new Pair<>(0, 0);
        }
        TreeNode<T> left = node.getLeft();
        TreeNode<T> right = node.getRight();
        if (left == null && right == null) {
            return new Pair<>(0, 0);
        }
        Pair<Integer, Integer> leftPair = helper(left);
        Pair<Integer, Integer> rightPair = helper(right);
        int leftHeight = leftPair.getFirst();
        int leftDiameter = leftPair.getSecond();
        int rightHeight = rightPair.getFirst();
        int rightDiameter = rightPair.getSecond();
        int rootHeight = 1 + Math.max(leftHeight, rightHeight);
        int rootDiameter = 0;
        if (left != null) {
            rootDiameter += leftHeight + 1;
        }
        if (right != null) {
            rootDiameter += rightHeight + 1;
        }
        rootDiameter = Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
        return new Pair<>(rootHeight, rootDiameter);
    }
}
