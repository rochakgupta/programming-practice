package tree.binary_tree.traversals;

import common.BinaryTreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> solve(BinaryTreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> nodesInCurrentLevel = new ArrayList<>();
            int numberOfNodesInCurrentLevel = queue.size();
            while (numberOfNodesInCurrentLevel > 0) {
                BinaryTreeNode node = queue.remove();
                nodesInCurrentLevel.add(node.getData());
                BinaryTreeNode left = node.getLeft();
                if (left != null) {
                    queue.add(left);
                }
                BinaryTreeNode right = node.getRight();
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
