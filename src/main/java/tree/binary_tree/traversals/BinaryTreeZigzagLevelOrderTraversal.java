package tree.binary_tree.traversals;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> solve(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> zigzagLevelOrderTraversal = new ArrayList<>();
        Stack<TreeNode> currentLevelStack = new Stack<>();
        currentLevelStack.add(root);
        int currentLevel = 1;
        while (!currentLevelStack.isEmpty()) {
            List<Integer> nodesInCurrentLevel = new ArrayList<>();
            Stack<TreeNode> nextLevelStack = new Stack<>();
            while (!currentLevelStack.isEmpty()) {
                TreeNode node = currentLevelStack.pop();
                nodesInCurrentLevel.add(node.getData());
                TreeNode left = node.getLeft();
                TreeNode right = node.getRight();
                if (currentLevel % 2 == 1) {
                    if (left != null) {
                        nextLevelStack.push(left);
                    }
                    if (right != null) {
                        nextLevelStack.push(right);
                    }
                } else {
                    if (right != null) {
                        nextLevelStack.push(right);
                    }
                    if (left != null) {
                        nextLevelStack.push(left);
                    }
                }
            }
            zigzagLevelOrderTraversal.add(nodesInCurrentLevel);
            ++currentLevel;
            currentLevelStack = nextLevelStack;
        }
        return zigzagLevelOrderTraversal;
    }
}
