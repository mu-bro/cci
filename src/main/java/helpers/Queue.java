package helpers;

public class Queue<E> {
    Node<E> first, last;

    public void push(E data) {
        Node newElem = new Node(data);
        if (first == null) {
            last = newElem;
            first = last;
        } else {
            last.next = newElem;
            last = newElem;
        }
    }

    public E pull() {
        if (first == null) {
            return null;
        }
        E data = first.data;
        first = first.next;
        return data;
    }
}
