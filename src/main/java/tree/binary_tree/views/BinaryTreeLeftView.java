package tree.binary_tree.views;

import common.Pair;
import common.TreeNode;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTreeLeftView<T> {

    public List<T> solve(TreeNode<T> root) {
        SortedMap<Integer, Pair<Integer, T>> leftView = new TreeMap<>();
        helper(root, 0, 0, leftView);
        return leftView.values()
                       .stream()
                       .map(Pair::getSecond)
                       .collect(Collectors.toList());
    }

    private void helper(TreeNode<T> node, int x, int y,
                               SortedMap<Integer, Pair<Integer, T>> leftView) {
        if (node != null) {
            Pair<Integer, T> pair = leftView.get(y);
            if (pair == null || x < pair.getFirst()) {
                leftView.put(y, new Pair<>(x, node.getData()));
            }
            helper(node.getLeft(), x - 1, y + 1, leftView);
            helper(node.getRight(), x + 1, y + 1, leftView);
        }
    }
}
