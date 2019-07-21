package tree.binary_tree.views;

import common.BinaryTreeNode;
import common.Pair;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTreeRightView {

    public static List<Integer> solve(BinaryTreeNode root) {
        SortedMap<Integer, Pair<Integer, Integer>> rightView = new TreeMap<>();
        helper(root, 0, 0, rightView);
        return rightView.values()
                        .stream()
                        .map(Pair::getValue)
                        .collect(Collectors.toList());
    }

    private static void helper(BinaryTreeNode node, int x, int y,
                               SortedMap<Integer, Pair<Integer, Integer>> rightView) {
        if (node != null) {
            Pair<Integer, Integer> pair = rightView.get(y);
            if (pair == null || pair.getKey() < x) {
                rightView.put(y, new Pair<>(x, node.getData()));
            }
            helper(node.getLeft(), x - 1, y + 1, rightView);
            helper(node.getRight(), x + 1, y + 1, rightView);
        }
    }
}
