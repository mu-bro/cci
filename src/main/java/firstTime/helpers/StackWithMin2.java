package firstTime.helpers;

public class StackWithMin2 extends Stack<Integer> {
    Stack<Integer> s2;

    public StackWithMin2() {
        s2 = new Stack<Integer>();
    }

    public void push(Integer value) {
        if (value <= min()) {
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pull() {
        int value = super.pull();
        if (value == min()) {
            s2.pull();
        }
        return value;
    }

    public int min() {
        if (s2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }
}
