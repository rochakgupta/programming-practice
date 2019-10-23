package tree.binary_tree.traversals;

import common.TreeNode;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeInOrderTraversalTest {

    private static TreeNode root;

    @BeforeClass
    public static void initialize() {
        root = TreeNode.data(1)
                       .left(TreeNode.data(2)
                                     .left(TreeNode.data(12)
                                                   .left(TreeNode.data(13))))
                       .right(TreeNode.data(3)
                                      .left(TreeNode.data(4)
                                                    .left(TreeNode.data(6)))
                                      .right(TreeNode.data(5)
                                                     .left(TreeNode.data(7))));
    }

    @Test
    public void testRecursive() {
        List<Integer> expected = Arrays.asList(13, 12, 2, 1, 6, 4, 3, 7, 5);
        List<Integer> obtained = BinaryTreeInOrderTraversal.solveRecursively(root);
        Assert.assertEquals(expected, obtained);
    }

    @Test
    public void testIterative() {
        List<Integer> expected = Arrays.asList(13, 12, 2, 1, 6, 4, 3, 7, 5);
        List<Integer> obtained = BinaryTreeInOrderTraversal.solveIteratively(root);
        Assert.assertEquals(expected, obtained);
    }
}