package common;

public class TreeNode {

    private Integer data;

    private TreeNode left;

    private TreeNode right;

    public static TreeNode data(Integer data) {
        TreeNode node = new TreeNode();
        node.data = data;
        return node;
    }

    public TreeNode left(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode right(TreeNode right) {
        this.right = right;
        return this;
    }

    public Integer getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
