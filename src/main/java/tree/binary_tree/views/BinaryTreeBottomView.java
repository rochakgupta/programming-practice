package tree.binary_tree.views;

import common.Pair;
import common.TreeNode;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTreeBottomView<T> {

    public List<T> solve(TreeNode<T> root) {
        SortedMap<Integer, Pair<Integer, T>> bottomView = new TreeMap<>();
        helper(root, 0, 0, bottomView);
        return bottomView.values()
                         .stream()
                         .map(Pair::getSecond)
                         .collect(Collectors.toList());
    }

    private void helper(TreeNode<T> node, int x, int y,
                               SortedMap<Integer, Pair<Integer, T>> bottomView) {
        if (node != null) {
            Pair<Integer, T> pair = bottomView.get(x);
            if (pair == null || pair.getFirst() < y) {
                bottomView.put(x, new Pair<>(y, node.getData()));
            }
            helper(node.getLeft(), x - 1, y + 1, bottomView);
            helper(node.getRight(), x + 1, y + 1, bottomView);
        }
    }
}
