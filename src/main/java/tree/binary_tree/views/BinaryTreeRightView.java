package tree.binary_tree.views;

import common.Pair;
import common.TreeNode;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTreeRightView<T> {

    public List<T> solve(TreeNode<T> root) {
        SortedMap<Integer, Pair<Integer, T>> rightView = new TreeMap<>();
        helper(root, 0, 0, rightView);
        return rightView.values()
                        .stream()
                        .map(Pair::getSecond)
                        .collect(Collectors.toList());
    }

    private void helper(TreeNode<T> node, int x, int y,
                               SortedMap<Integer, Pair<Integer, T>> rightView) {
        if (node != null) {
            Pair<Integer, T> pair = rightView.get(y);
            if (pair == null || pair.getFirst() < x) {
                rightView.put(y, new Pair<>(x, node.getData()));
            }
            helper(node.getLeft(), x - 1, y + 1, rightView);
            helper(node.getRight(), x + 1, y + 1, rightView);
        }
    }
}
