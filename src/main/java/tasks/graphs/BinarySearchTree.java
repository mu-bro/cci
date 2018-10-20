package tasks.graphs;

public class BinarySearchTree extends Tree {
    public BinarySearchTree(int data) {
        super(data);
    }
    public BinarySearchTree() {

    }

    public void add(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        add(root, data);
    }

    private void add(TreeNode node, int data) {
        if (data < node.data) {
            if (node.left == null) {
                node.addLeft(data);
            } else {
                add(node.left, data);
            }
        } else {
            if (node.right == null) {
                node.addRight(data);
            } else {
                add(node.right, data);
            }
        }
    }

    @Override
    public String toString() {
        if (root != null) {
            return root.toString();
        }
        return null;
    }
}
