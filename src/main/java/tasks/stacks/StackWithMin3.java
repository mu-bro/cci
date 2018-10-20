package tasks.stacks;

public class StackWithMin3 implements StackI<Integer> {

    Stack<Integer> s2 = new Stack<>();
    private Node top;


    public Integer pop() {
        if (top != null) {
            Integer value = top.value;
            if (top.value == getMin()) {
                s2.pop();
            }
            top = top.prev;
            return value;
        }
        return null;
    }

    public Integer peek() {
        return (top != null) ? top.value : null;
    }

    public void push(Integer item) {
        if (top == null) {
            top = new Node(item);
        } else {
            Node newTop = new Node(item);
            newTop.prev = top;
            top = newTop;
        }
        if (item < getMin()) {
            s2.push(item);
        }
    }

    public int getMin() {
        return s2.isEmpty() ? Integer.MAX_VALUE : s2.peek();
    }

    private class Node {
        public Integer value;
        public Node prev;

        public Node(Integer value) {
            this.value = value;
        }
    }
}
