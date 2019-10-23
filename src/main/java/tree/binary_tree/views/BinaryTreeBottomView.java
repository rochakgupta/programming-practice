package tree.binary_tree.views;

import common.Pair;
import common.TreeNode;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTreeBottomView {

    public static List<Integer> solve(TreeNode root) {
        SortedMap<Integer, Pair<Integer, Integer>> bottomView = new TreeMap<>();
        helper(root, 0, 0, bottomView);
        return bottomView.values()
                         .stream()
                         .map(Pair::getSecond)
                         .collect(Collectors.toList());
    }

    private static void helper(TreeNode node, int x, int y,
                               SortedMap<Integer, Pair<Integer, Integer>> bottomView) {
        if (node != null) {
            Pair<Integer, Integer> pair = bottomView.get(x);
            if (pair == null || pair.getFirst() < y) {
                bottomView.put(x, new Pair<>(y, node.getData()));
            }
            helper(node.getLeft(), x - 1, y + 1, bottomView);
            helper(node.getRight(), x + 1, y + 1, bottomView);
        }
    }
}
