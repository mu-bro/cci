package tasks.graphs;

public class Tree {
    public TreeNode root;

    public Tree(int data) {
        root = new TreeNode(data);
    }
    public Tree(TreeNode node) {
        root = node;
    }

    public Tree() {

    }

    @Override
    public String toString() {
        return root.toString();
    }
}
