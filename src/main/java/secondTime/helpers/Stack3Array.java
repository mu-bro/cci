package secondTime.helpers;

public class Stack3Array {
    private Integer[] arr = new Integer[1000];
    private int[] arrLength = new int[4];

    public boolean isEmpty(int stackNum) {
        return arrLength[stackNum] == 0;
    }

    public Integer peek(int stackNum) {
        return arr[getLastElem(stackNum)];
    }

    public Integer pop(int stackNum) {
        if (isEmpty(stackNum)) return null;
        Integer val = arr[getLastElem(stackNum)];
        arrLength[stackNum]--;
        return val;
    }

    public void push(Integer item, int stackNum) {
        arrLength[stackNum]++;
        arr[getLastElem(stackNum)] = item;
    }

    private int getLastElem(int stackNum) {
        Integer length = arrLength[stackNum];
        return 3 * (length - 1) + (stackNum - 1);
    }
}
