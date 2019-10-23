package tree.binary_tree.views;

import common.Pair;
import common.TreeNode;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTreeTopView {

    public static List<Integer> solve(TreeNode root) {
        SortedMap<Integer, Pair<Integer, Integer>> topView = new TreeMap<>();
        helper(root, 0, 0, topView);
        return topView.values()
                      .stream()
                      .map(Pair::getSecond)
                      .collect(Collectors.toList());
    }

    private static void helper(TreeNode node, int x, int y,
                               SortedMap<Integer, Pair<Integer, Integer>> topView) {
        if (node != null) {
            Pair<Integer, Integer> pair = topView.get(x);
            if (pair == null || y < pair.getFirst()) {
                topView.put(x, new Pair<>(y, node.getData()));
            }
            helper(node.getLeft(), x - 1, y + 1, topView);
            helper(node.getRight(), x + 1, y + 1, topView);
        }
    }
}
