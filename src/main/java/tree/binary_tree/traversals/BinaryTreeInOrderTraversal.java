package tree.binary_tree.traversals;

import common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {

    public static List<Integer> solveRecursively(BinaryTreeNode root) {
        List<Integer> inOrderTraversal = new ArrayList<>();
        if (root != null) {
            List<Integer> left = solveRecursively(root.getLeft());
            List<Integer> right = solveRecursively(root.getRight());
            inOrderTraversal.addAll(left);
            inOrderTraversal.add(root.getData());
            inOrderTraversal.addAll(right);
        }
        return inOrderTraversal;
    }

    public static List<Integer> solveIteratively(BinaryTreeNode root) {
        List<Integer> inOrderTraversal = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode currentNode = root;
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
