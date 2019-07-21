package common;

public class BinaryTreeNode {

    private Integer data;

    private BinaryTreeNode left;

    private BinaryTreeNode right;

    private BinaryTreeNode() {
    }

    public static BinaryTreeNode with(Integer data) {
        BinaryTreeNode node = new BinaryTreeNode();
        node.data = data;
        return node;
    }

    public BinaryTreeNode left(BinaryTreeNode left) {
        this.left = left;
        return this;
    }

    public BinaryTreeNode right(BinaryTreeNode right) {
        this.right = right;
        return this;
    }

    public Integer getData() {
        return data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }
}
