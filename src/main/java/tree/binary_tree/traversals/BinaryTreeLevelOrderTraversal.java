package tree.binary_tree.traversals;

import common.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> solve(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> nodesInCurrentLevel = new ArrayList<>();
            int numberOfNodesInCurrentLevel = queue.size();
            while (numberOfNodesInCurrentLevel > 0) {
                TreeNode node = queue.remove();
                nodesInCurrentLevel.add(node.getData());
                TreeNode left = node.getLeft();
                if (left != null) {
                    queue.add(left);
                }
                TreeNode right = node.getRight();
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
