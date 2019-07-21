package tree.binary_tree.traversals;

import common.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalTest {

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
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Collections.singletonList(1));
        expected.add(Arrays.asList(2, 3));
        expected.add(Arrays.asList(12, 4, 5));
        expected.add(Arrays.asList(13, 6, 7));
        List<List<Integer>> obtained = BinaryTreeLevelOrderTraversal.solve(root);
        Assert.assertEquals(expected, obtained);
    }
}