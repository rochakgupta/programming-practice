package tree.binary_tree.traversals;

import common.TreeNode;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeInOrderTraversalTest {

    private static TreeNode<Integer> root;

    private static BinaryTreeInOrderTraversal<Integer> solver;

    @BeforeClass
    public static void initialize() {
        root = new TreeNode<>(1);

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

        solver = new BinaryTreeInOrderTraversal<>();
    }

    @Test
    public void testRecursive() {
        List<Integer> expected = List.of(13, 12, 2, 1, 6, 4, 3, 7, 5);
        List<Integer> obtained = solver.solveRecursively(root);
        Assert.assertEquals(expected, obtained);
    }

    @Test
    public void testIterative() {
        List<Integer> expected = List.of(13, 12, 2, 1, 6, 4, 3, 7, 5);
        List<Integer> obtained = solver.solveIteratively(root);
        Assert.assertEquals(expected, obtained);
    }
}