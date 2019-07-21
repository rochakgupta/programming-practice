package tree.binary_tree.traversals;

import common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> solve(BinaryTreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> zigzagLevelOrderTraversal = new ArrayList<>();
        Stack<BinaryTreeNode> currentLevelStack = new Stack<>();
        currentLevelStack.add(root);
        int currentLevel = 1;
        while (!currentLevelStack.isEmpty()) {
            List<Integer> nodesInCurrentLevel = new ArrayList<>();
            Stack<BinaryTreeNode> nextLevelStack = new Stack<>();
            while (!currentLevelStack.isEmpty()) {
                BinaryTreeNode node = currentLevelStack.pop();
                nodesInCurrentLevel.add(node.getData());
                BinaryTreeNode left = node.getLeft();
                BinaryTreeNode right = node.getRight();
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
