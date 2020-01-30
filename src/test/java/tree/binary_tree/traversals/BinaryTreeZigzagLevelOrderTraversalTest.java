package tree.binary_tree.traversals;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversalTest {

    @Test
    public void test() {
        TreeNode<Integer> root = new TreeNode<>(1);

        TreeNode<Integer> left = new TreeNode<>(2);
        TreeNode<Integer> right = new TreeNode<>(3);
        root.setLeft(left);
        root.setRight(right);

        TreeNode<Integer> leftLeft = new TreeNode<>(12);
        TreeNode<Integer> rightLeft = new TreeNode<>(4);
        TreeNode<Integer> rightRight = new TreeNode<>(5);
        left.setLeft(leftLeft);
        right.setLeft(rightLeft);
        right.setRight(rightRight);

        TreeNode<Integer> leftLeftLeft = new TreeNode<>(13);
        TreeNode<Integer> rightLeftLeft = new TreeNode<>(6);
        TreeNode<Integer> rightRightLeft = new TreeNode<>(7);
        leftLeft.setLeft(leftLeftLeft);
        rightLeft.setLeft(rightLeftLeft);
        rightRight.setLeft(rightRightLeft);

        BinaryTreeZigzagLevelOrderTraversal<Integer> solver = new BinaryTreeZigzagLevelOrderTraversal<>();

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Collections.singletonList(1));
        expected.add(List.of(3, 2));
        expected.add(List.of(12, 4, 5));
        expected.add(List.of(7, 6, 13));
        List<List<Integer>> obtained = solver.solve(root);
        Assert.assertEquals(expected, obtained);
    }
}