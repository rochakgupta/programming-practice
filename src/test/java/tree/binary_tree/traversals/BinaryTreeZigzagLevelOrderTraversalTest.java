package tree.binary_tree.traversals;

import org.junit.Assert;
import org.junit.Test;
import common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversalTest {

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
        expected.add(Arrays.asList(3, 2));
        expected.add(Arrays.asList(12, 4, 5));
        expected.add(Arrays.asList(7, 6, 13));
        List<List<Integer>> obtained = BinaryTreeZigzagLevelOrderTraversal.solve(root);
        Assert.assertEquals(expected, obtained);
    }
}