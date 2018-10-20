package tasks.stacks;

import helpers.Node;

public class StackWithSet<T> implements StackI<T> {
    private final int capacity = 3;
    private Node[] set = new Node[100];
    private int currentStack = 0;
    private int currentSize = 0;


    public void push(T data) {
        Node elem = new Node(data);
        Node top = set[currentStack];
        elem.next = top;
        set[currentStack] = elem;
        currentSize++;
        if (currentSize == capacity) {
            currentStack++;
            currentSize = 0;
        }
    }
    public T peek() {
        return (T) set[currentStack].data;
    }
    public T pop() {
        if (currentStack == 0 && currentSize == 0) {
            return null;
        }
        Node top = set[currentStack];
        while (top == null && currentStack > 0) {
            currentStack--;
            top = set[currentStack];
        }
        if (top == null) {
            return null;
        }
        if (currentSize == 0) {
            currentSize = capacity;
        }
        currentSize--;
        set[currentStack] = top.next;
        return (T) top.data;
    }


    public T popAt(int stackNum) {
        Node top = set[stackNum];
        if (top == null) {
            return null;
        }
        set[stackNum] = top.next;
        if (stackNum == currentStack) {
            currentSize--;
        }
        return (T) top.data;
    }


}
