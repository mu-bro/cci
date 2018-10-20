package tasks.firstTime;

import tasks.stacks.Stack;

public class Chapter3 {

    public static Stack sortStack(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack();
        while (!s1.isEmpty()) {
            int tmp = s1.pop();
            while(!s2.isEmpty() && s2.peek() > tmp) {
                s1.push(s2.pop());
            }
            s2.push(tmp);
        }
        return s2;
    }





}
