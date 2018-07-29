package firstTime.helpers;

public class StackArray<T> {
    int topElem = 0;
    T[] arr = (T[]) new Object[300];

    public T pull() {
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
