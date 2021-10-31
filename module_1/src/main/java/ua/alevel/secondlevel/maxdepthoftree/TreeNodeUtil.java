package ua.alevel.secondlevel.maxdepthoftree;

public class TreeNodeUtil {

    private TreeNode treeRoot;

    public TreeNodeUtil() {
        buildTree();
    }

    public int getMaxLength() {

        return treeRoot != null ? getMaxLength(treeRoot, 0) : 0;
    }

    private int getMaxLength(TreeNode root, int length) {

        int maxLength = length + 1;

        if (root.left != null) {
            maxLength = Math.max(maxLength, getMaxLength(root.left, length + 1));
        }

        if (root.right != null) {
            maxLength = Math.max(maxLength, getMaxLength(root.right, length + 1));
        }

        return maxLength;
    }

    public void consoleOutput() {
        consoleOutputNode(treeRoot, 0);
    }

    private void consoleOutputNode(TreeNode root, int tabNumber) {
        System.out.println("Your tree: ");
        String output = "\t".repeat(Math.max(0, tabNumber)) +
                root.getVal() + ":\n";
        System.out.println(output);

        if (root.getLeft() != null) {
            consoleOutputNode(root.getLeft(), tabNumber + 1);
        }

        if (root.getRight() != null) {
            consoleOutputNode(root.getRight(), tabNumber + 1);
        }

    }

    private void buildTree() {
        treeRoot = new TreeNode(1);
        treeRoot.setLeft(2);
        treeRoot.setRight(3);

        treeRoot.getLeft().setLeft(4);
        treeRoot.getLeft().setRight(5);
        treeRoot.getRight().setLeft(6);
        treeRoot.getRight().setRight(7);

        treeRoot.getLeft().getLeft().setLeft(8);

        treeRoot.getLeft().getLeft().getLeft().setLeft(9);
        treeRoot.getLeft().getLeft().getLeft().setRight(10);

        treeRoot.getLeft().getLeft().getLeft().getRight().setLeft(11);
    }
}