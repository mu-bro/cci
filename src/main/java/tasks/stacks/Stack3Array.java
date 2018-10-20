package tasks.stacks;

import java.util.Queue;

public class Stack3Array<T> {
    int capacity = 300;
    T[] arr = (T[]) new Object[capacity * 3];
    int[] topPointer = {0, capacity / 3 * 1, capacity / 3 * 2};


    public T pull(int stackNum) {
        if (topPointer[stackNum] > capacity / 3 * stackNum) {
            T data = arr[topPointer[stackNum]];
            arr[topPointer[stackNum]] = null;
            topPointer[stackNum]--;
            return data;
        }
        return null;
    }

    public T peek(int stackNum) {
        if (topPointer[stackNum] > capacity / 3 * stackNum) {
            return arr[topPointer[stackNum]];
        }
        return null;
    }

    public void push(T data, int stackNum) {
        arr[++topPointer[stackNum]] = data;
    }

}
