package tree.binary_tree.traversals;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal<T> {

    public List<List<T>> solve(TreeNode<T> root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<T>> zigzagLevelOrderTraversal = new ArrayList<>();
        Stack<TreeNode<T>> currentLevelStack = new Stack<>();
        currentLevelStack.add(root);
        int currentLevel = 1;
        while (!currentLevelStack.isEmpty()) {
            List<T> nodesInCurrentLevel = new ArrayList<>();
            Stack<TreeNode<T>> nextLevelStack = new Stack<>();
            while (!currentLevelStack.isEmpty()) {
                TreeNode<T> node = currentLevelStack.pop();
                nodesInCurrentLevel.add(node.getData());
                TreeNode<T> left = node.getLeft();
                TreeNode<T> right = node.getRight();
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
