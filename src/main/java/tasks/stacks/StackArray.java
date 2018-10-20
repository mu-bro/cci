package tasks.stacks;

public class StackArray<T> implements StackI<T> {
    int topElem = 0;
    T[] arr = (T[]) new Object[300];

    public T pop() {
        if (topElem > 0) {
            T data = arr[topElem];
            arr[topElem] = null;
            topElem--;
            return data;
        }
        return null;
    }
    public T peek() {
        if (topElem > 0) {
            return arr[topElem];
        }
        return null;
    }
    public void push(T data) {
        arr[++topElem] = data;
    }
}
