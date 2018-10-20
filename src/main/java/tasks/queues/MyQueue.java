package tasks.queues;

import tasks.stacks.Stack;

public class MyQueue<T> implements QueueI<T> {
    private Stack straight = new Stack();
    private Stack reversed = new Stack();
    public void push(T data) {
        straight.push(data);
    }

    public T pull() {
        if (!reversed.isEmpty()) {
            return (T) reversed.pop();
        }
        while (!straight.isEmpty()) {
            reversed.push(straight.pop());
        }
        return (T) reversed.pop();
    }
}
