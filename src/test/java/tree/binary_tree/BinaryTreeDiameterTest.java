package tree.binary_tree;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeDiameterTest {

    @Test
    public void test() {
        TreeNode root = TreeNode.data(1)
                                .left(TreeNode.data(2)
                                              .left(TreeNode.data(12)
                                                            .left(TreeNode.data(13))))
                                .right(TreeNode.data(3)
                                               .left(TreeNode.data(4)
                                                             .left(TreeNode.data(6)))
                                               .right(TreeNode.data(5)
                                                              .left(TreeNode.data(7))));
        int expected = 6;
        int obtained = BinaryTreeDiameter.solve(root);
        Assert.assertEquals(expected, obtained);
    }
}