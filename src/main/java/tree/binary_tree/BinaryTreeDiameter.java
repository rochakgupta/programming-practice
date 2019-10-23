package tree.binary_tree;

import common.Pair;
import common.TreeNode;

public class BinaryTreeDiameter {

    public static int solve(TreeNode root) {
        Pair<Integer, Integer> pair = helper(root);
        return pair.getSecond();
    }

    private static Pair<Integer, Integer> helper(TreeNode node) {
        if (node == null) {
            return new Pair<>(0, 0);
        }
        TreeNode left = node.getLeft();
        TreeNode right = node.getRight();
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
