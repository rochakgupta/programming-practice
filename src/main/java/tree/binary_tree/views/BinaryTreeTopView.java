package tree.binary_tree.views;

import common.BinaryTreeNode;
import common.Pair;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTreeTopView {

    public static List<Integer> solve(BinaryTreeNode root) {
        SortedMap<Integer, Pair<Integer, Integer>> topView = new TreeMap<>();
        helper(root, 0, 0, topView);
        return topView.values()
                      .stream()
                      .map(Pair::getValue)
                      .collect(Collectors.toList());
    }

    private static void helper(BinaryTreeNode node, int x, int y,
                               SortedMap<Integer, Pair<Integer, Integer>> topView) {
        if (node != null) {
            Pair<Integer, Integer> pair = topView.get(x);
            if (pair == null || y < pair.getKey()) {
                topView.put(x, new Pair<>(y, node.getData()));
            }
            helper(node.getLeft(), x - 1, y + 1, topView);
            helper(node.getRight(), x + 1, y + 1, topView);
        }
    }
}
