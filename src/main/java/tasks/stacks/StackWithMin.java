package tasks.stacks;

import helpers.Node;

public class StackWithMin<T> implements StackI<Integer> {
    MNode<Integer> top;

    public Integer pop() {
        if (top == null) {
            return null;
        }
        Integer data = top.data;
        top = (MNode) top.next;
        return data;
    }

    public Integer peek() {
        return top.data;
    }

    public void push(Integer data) {
        int newMin = Math.min(data, min());
        MNode item = new MNode(data);
        item.min = newMin;
        item.next = top;
        top = item;
    }

    public Integer min() {
        if (top == null) {
            return Integer.MAX_VALUE;
        } else {
            return top.min;
        }
    }

    private class MNode<T> extends Node<Integer> {
        public int min;

        public MNode(Integer data) {
            super(data);
        }
    }
}
