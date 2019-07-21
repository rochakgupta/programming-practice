package tree.binary_tree;

import org.junit.Assert;
import org.junit.Test;
import common.BinaryTreeNode;

public class BinaryTreeHeightTest {

    @Test
    public void test() {
        BinaryTreeNode root = BinaryTreeNode.with(1)
                                .left(BinaryTreeNode.with(2)
                                              .left(BinaryTreeNode.with(12)
                                                            .left(BinaryTreeNode.with(13))))
                                .right(BinaryTreeNode.with(3)
                                               .left(BinaryTreeNode.with(4)
                                                             .left(BinaryTreeNode.with(6)))
                                               .right(BinaryTreeNode.with(5)
                                                              .left(BinaryTreeNode.with(7))));
        int expected = 3;
        int obtained = BinaryTreeHeight.solve(root);
        Assert.assertEquals(expected, obtained);
    }
}