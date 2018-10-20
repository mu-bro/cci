package tasks.secondTime.Chapter3;

import tasks.queues.QueueI;
import tasks.stacks.Stack;

public class MyQueue2 implements QueueI<Integer> {
    private Stack<Integer> straight = new Stack();
    private Stack<Integer> reversed = new Stack();

    public void push(Integer data) {
        reversed.push(data);
    }

    public Integer pull() {
        if (straight.isEmpty()) {
            while (!reversed.isEmpty()) {
                straight.push(reversed.pop());
            }
        }
        return straight.pop();
    }
}
