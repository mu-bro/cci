package tasks;

import tasks.stacks.Stack;

public class TowersOfHanoi {
    private Stack<Integer> stack1 = new Stack();
    private Stack<Integer> stack2 = new Stack();
    private Stack<Integer> stack3 = new Stack();
    private int diskNum;

    public TowersOfHanoi(int diskSize) {
        diskNum = diskSize;
        for(int i = diskSize; i >= 1; i--) {
            stack1.push(i);
        }
    }

    public Stack run() throws Exception {
        hanoi(diskNum, stack1, stack2, stack3);
        return stack3;
    }

    private void hanoi(int diskNum, Stack src, Stack aux, Stack dst) throws Exception {
        if (diskNum <= 0) return;
        hanoi(diskNum - 1, src, dst, aux);
        move(src, dst);
        hanoi(diskNum - 1, aux, src, dst);
    }

    private void move(Stack<Integer> from, Stack<Integer> to) throws Exception {
        Integer disk = from.pop();
        Integer diskToPutOn = to.peek();
        if (diskToPutOn != null && disk > diskToPutOn) {
            throw new Exception("Disk can be placed on larger disk!");
        }
        to.push(disk);
    }
}
