package tree.binary_tree.views;

import common.BinaryTreeNode;
import common.Pair;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTreeBottomView {

    public static List<Integer> solve(BinaryTreeNode root) {
        SortedMap<Integer, Pair<Integer, Integer>> bottomView = new TreeMap<>();
        helper(root, 0, 0, bottomView);
        return bottomView.values()
                         .stream()
                         .map(Pair::getValue)
                         .collect(Collectors.toList());
    }

    private static void helper(BinaryTreeNode node, int x, int y,
                               SortedMap<Integer, Pair<Integer, Integer>> bottomView) {
        if (node != null) {
            Pair<Integer, Integer> pair = bottomView.get(x);
            if (pair == null || pair.getKey() < y) {
                bottomView.put(x, new Pair<>(y, node.getData()));
            }
            helper(node.getLeft(), x - 1, y + 1, bottomView);
            helper(node.getRight(), x + 1, y + 1, bottomView);
        }
    }
}
