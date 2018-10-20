package tasks.graphs;

public class TreeNode {
    public TreeNode parent;
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode parent) {
        this.data = data;
        this.parent = parent;
    }
    public void addLeft(int data) {
        left = new TreeNode(data, this);
    }
    public void addLeft(TreeNode node) {
        left = node;
        node.parent = this;
    }
    public void addRight(TreeNode node) {
        right = node;
        node.parent = this;
    }
    public void addRight(int data) {
        right = new TreeNode(data, this);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (left != null || right != null) {
            result.append("{");
        }
        if (left != null) {
            result.append(left.toString());
        }
        if (left != null && right != null) {
            result.append(",");
        }
        if (right != null) {
            result.append(right.toString());
        }
        if (left != null || right != null) {
            result.append("}");
        }
        return data + result.toString();
    }
}
