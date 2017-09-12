package helpers;

public class StackWithSet<T> {
    private final int capacity = 5;
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
        set[currentStack] = top.next;
        currentSize--;
        if (top.next == null && currentSize != 0) {
            currentSize = capacity - 1;
            currentStack--;
        }
        return (T) top.data;
    }

}
