package tasks.stacks;

import helpers.Node;

public class Stack<T> implements StackI<T> {
    Node<T> top;

    public T pop() {
        if (top == null) {
            return null;
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (top == null) {
            return null;
        }
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

    @Override
    public String toString() {
        return (top == null) ? "" : top.toString();
    }
}
