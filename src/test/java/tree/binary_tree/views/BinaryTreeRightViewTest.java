package tree.binary_tree.views;

import org.junit.Assert;
import org.junit.Test;
import common.BinaryTreeNode;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeRightViewTest {

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
        List<Integer> expected = Arrays.asList(1, 3, 5, 7);
        List<Integer> obtained = BinaryTreeRightView.solve(root);
        Assert.assertEquals(expected, obtained);
    }
}