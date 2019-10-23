package tree.binary_tree.traversals;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalTest {

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
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Collections.singletonList(1));
        expected.add(Arrays.asList(2, 3));
        expected.add(Arrays.asList(12, 4, 5));
        expected.add(Arrays.asList(13, 6, 7));
        List<List<Integer>> obtained = BinaryTreeLevelOrderTraversal.solve(root);
        Assert.assertEquals(expected, obtained);
    }
}