package helpers;

public class Stack<T> {
    Node<T> top;
    public T pull() {
        if (top == null) {
            return null;
        }
        T data = top.data;
        top = top.next;
        return data;
    }
    public T peek() {
        return top.data;
    }
    public void push(T data) {
         Node item = new Node(data);
         item.next = top;
         top = item;
    }
    public boolean isEmpty() {
        return top == null;
    }
}
