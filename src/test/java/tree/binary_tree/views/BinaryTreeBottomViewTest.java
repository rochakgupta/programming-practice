package tree.binary_tree.views;

import common.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeBottomViewTest {

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
        List<Integer> expected = Arrays.asList(13, 12, 6, 4, 7, 5);
        List<Integer> obtained = BinaryTreeBottomView.solve(root);
        Assert.assertEquals(expected, obtained);
    }
}