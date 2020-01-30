package tree.binary_tree.traversals;

import common.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal<T> {

    public List<List<T>> solve(TreeNode<T> root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<T>> levelOrderTraversal = new ArrayList<>();
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<T> nodesInCurrentLevel = new ArrayList<>();
            int numberOfNodesInCurrentLevel = queue.size();
            while (numberOfNodesInCurrentLevel > 0) {
                TreeNode<T> node = queue.remove();
                nodesInCurrentLevel.add(node.getData());
                TreeNode<T> left = node.getLeft();
                if (left != null) {
                    queue.add(left);
                }
                TreeNode<T> right = node.getRight();
                if (right != null) {
                    queue.add(right);
                }
                numberOfNodesInCurrentLevel--;
            }
            levelOrderTraversal.add(nodesInCurrentLevel);
        }
        return levelOrderTraversal;
    }
}
