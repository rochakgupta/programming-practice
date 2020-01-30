package tree.binary_tree.traversals;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversal<T> {

    public List<T> solveRecursively(TreeNode<T> root) {
        List<T> inOrderTraversal = new ArrayList<>();
        if (root != null) {
            List<T> left = solveRecursively(root.getLeft());
            List<T> right = solveRecursively(root.getRight());
            inOrderTraversal.addAll(left);
            inOrderTraversal.add(root.getData());
            inOrderTraversal.addAll(right);
        }
        return inOrderTraversal;
    }

    public List<T> solveIteratively(TreeNode<T> root) {
        List<T> inOrderTraversal = new ArrayList<>();
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            }
            currentNode = stack.pop();
            inOrderTraversal.add(currentNode.getData());
            currentNode = currentNode.getRight();
        }
        return inOrderTraversal;
    }
}
