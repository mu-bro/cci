package helpers;

public class NodeHolder {
    int length;
    Node<Integer> lastNode;

    public NodeHolder(int length, Node<Integer> lastNode) {
        this.length = length;
        this.lastNode = lastNode;
    }
}
