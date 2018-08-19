package firstTime.helpers;

public class TreeNode {
    public boolean visited = false;
    public TreeNode parent;
    public TreeNode right;
    public TreeNode left;
    public int data;
    public TreeNode(int data) {
        this.data = data;
    }
    public TreeNode addLeft(int data) {
        left = new TreeNode(data);
        left.parent = this;
        return left;
    }
    public TreeNode addRight(int data) {
        right = new TreeNode(data);
        right.parent = this;
        return right;
    }

    @Override
    public String toString() {
        String l = left == null ? "" : left.toString();
        String r = right == null ? "" : right.toString();
        String lr = (l == "" && r == "") ? "" : " {" + l + "," + r + "}";
        return data + lr;
    }
}
