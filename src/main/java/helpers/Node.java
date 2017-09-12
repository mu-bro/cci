package helpers;

public class Node<E> {
    public E data;
    public Node<E> next;
    public Node<E> prev;

    public Node(E data) {
        this.data = data;
    }

    public Node add(Node newElem) {
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = newElem;
        newElem.prev = n;
        return this;
    }

    public Node add(E data) {
        Node newElem = new Node(data);
        return add(newElem);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node n = this;
        while (n.next != null) {
            result.append(n.data);
            n = n.next;
        }
        result.append(n.data);
        return result.toString();
    }
}
