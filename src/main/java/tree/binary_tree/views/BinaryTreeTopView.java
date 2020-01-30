package tree.binary_tree.views;

import common.Pair;
import common.TreeNode;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTreeTopView<T> {

    public List<T> solve(TreeNode<T> root) {
        SortedMap<Integer, Pair<Integer, T>> topView = new TreeMap<>();
        helper(root, 0, 0, topView);
        return topView.values()
                      .stream()
                      .map(Pair::getSecond)
                      .collect(Collectors.toList());
    }

    private void helper(TreeNode<T> node, int x, int y,
                        SortedMap<Integer, Pair<Integer, T>> topView) {
        if (node != null) {
            Pair<Integer, T> pair = topView.get(x);
            if (pair == null || y < pair.getFirst()) {
                topView.put(x, new Pair<>(y, node.getData()));
            }
            helper(node.getLeft(), x - 1, y + 1, topView);
            helper(node.getRight(), x + 1, y + 1, topView);
        }
    }
}
