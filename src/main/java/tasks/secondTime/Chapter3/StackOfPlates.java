package tasks.secondTime.Chapter3;

import helpers.Node;
import tasks.stacks.StackI;

public class StackOfPlates implements StackI<Integer> {
    public static final int STACK_SIZE = 3;
    private Node<Integer>[] stacks = new Node[100];
    private int[] stackLengths = new int[100];
    private int currentStack = 0;

    public Integer pop() {
        if (isEmpty(currentStack)) {
            if (!decreaseStack()) {
                return null;
            }
        }
        Node<Integer> value = stacks[currentStack];
        stacks[currentStack] = value.next;
        stackLengths[currentStack]--;
        return value.data;
    }

    public Integer peek() {
        if (isEmpty(currentStack)) {
            if (!decreaseStack()) {
                return null;
            }
        }
        return stacks[currentStack].data;
    }

    public Integer popAt(int stack) {
        if (isEmpty(stack)) {
            return null;
        }
        Node<Integer> value = stacks[stack];
        stacks[stack] = value.next;
        stackLengths[stack]--;
        return value.data;
    }

    public void push(Integer integer) {
        if (isFull(currentStack)) {
            currentStack++;
        }
        if (isEmpty(currentStack)) {
            stacks[currentStack] = new Node<>(integer);
        } else {
            Node<Integer> newNode = new Node<>(integer);
            newNode.next = stacks[currentStack];
            stacks[currentStack] = newNode;
        }
        stackLengths[currentStack]++;
    }

    private boolean isEmpty(int stack) {
        return stackLengths[stack] == 0;
    }

    private boolean isFull(int stack) {
        return stackLengths[stack] == STACK_SIZE;
    }

    private boolean decreaseStack() {
        while (currentStack >= 0 && isEmpty(currentStack)) {
            currentStack--;
        }
        if (currentStack < 0) {
            return false;
        }
        return true;
    }
}
