package ua.alevel.maxdepthoftree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public void setLeft(int x) {
        left = new TreeNode(x);
    }

    public void setRight(int x) {
        right = new TreeNode(x);
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public int getVal() {
        return val;
    }
}
