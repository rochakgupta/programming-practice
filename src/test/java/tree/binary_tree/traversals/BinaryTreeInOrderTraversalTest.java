package tree.binary_tree.traversals;

import common.BinaryTreeNode;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeInOrderTraversalTest {

    private static BinaryTreeNode root;

    @BeforeClass
    public static void initialize() {
        root = BinaryTreeNode.with(1)
                             .left(BinaryTreeNode.with(2)
                                                 .left(BinaryTreeNode.with(12)
                                                                     .left(BinaryTreeNode.with(13))))
                             .right(BinaryTreeNode.with(3)
                                                  .left(BinaryTreeNode.with(4)
                                                                      .left(BinaryTreeNode.with(6)))
                                                  .right(BinaryTreeNode.with(5)
                                                                       .left(BinaryTreeNode.with(7))));
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