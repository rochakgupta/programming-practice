package tree.binary_tree.views;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeTopViewTest {

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

        BinaryTreeTopView<Integer> solver = new BinaryTreeTopView<>();

        List<Integer> expected = List.of(13, 12, 2, 1, 3, 5);
        List<Integer> obtained = solver.solve(root);
        Assert.assertEquals(expected, obtained);
    }
}