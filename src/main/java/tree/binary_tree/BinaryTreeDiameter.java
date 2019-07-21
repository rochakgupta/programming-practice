package tree.binary_tree;

import common.BinaryTreeNode;
import common.Pair;

public class BinaryTreeDiameter {

    public static int solve(BinaryTreeNode root) {
        Pair<Integer, Integer> pair = helper(root);
        return pair.getValue();
    }

    private static Pair<Integer, Integer> helper(BinaryTreeNode node) {
        if (node == null) {
            return new Pair<>(0, 0);
        }
        BinaryTreeNode left = node.getLeft();
        BinaryTreeNode right = node.getRight();
        if (left == null && right == null) {
            return new Pair<>(0, 0);
        }
        Pair<Integer, Integer> leftPair = helper(left);
        Pair<Integer, Integer> rightPair = helper(right);
        int leftHeight = leftPair.getKey();
        int leftDiameter = leftPair.getValue();
        int rightHeight = rightPair.getKey();
        int rightDiameter = rightPair.getValue();
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
