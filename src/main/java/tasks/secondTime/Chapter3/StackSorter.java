package tasks.secondTime.Chapter3;

import tasks.stacks.Stack;

public class StackSorter {

    public static Stack<Integer> sort(Stack<Integer> s1) {
        boolean sorted = false;
        Stack<Integer> s2 = new Stack<>();

        while (!sorted) {

            int max = s1.pop();
            while (!s1.isEmpty()) {
                if (s1.peek() > max) {
                    s2.push(max);
                    max = s1.pop();
                } else {
                    s2.push(s1.pop());
                }
            }
            s1.push(max);

            sorted = true;
            while (!s2.isEmpty()) {
                if (s2.peek() > s1.peek()) {
                    sorted = false;
                }
                s1.push(s2.pop());
            }
        }
        return s1;
    }

    public static Stack<Integer> sort2(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            Integer max = s1.pop();
            while (!s2.isEmpty() && s2.peek() < max) {
                s1.push(s2.pop());
            }
            s2.push(max);
        }
        return s2;
    }
}
