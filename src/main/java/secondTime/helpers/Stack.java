package secondTime.helpers;

import java.util.LinkedList;
import java.util.List;

public class Stack<T> implements StackI<T> {
    private List<T> list = new LinkedList<>();

    public boolean isEmpty() {
        return false;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return list.get(0);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        T item = list.get(0);
        list.remove(0);
        return item;
    }

    public void push(T o) {
        list.add(o);
    }
}
