package tree.binary_tree.views;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeRightViewTest {

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
        List<Integer> expected = Arrays.asList(1, 3, 5, 7);
        List<Integer> obtained = BinaryTreeRightView.solve(root);
        Assert.assertEquals(expected, obtained);
    }
}