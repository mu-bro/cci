package tasks.secondTime.Chapter2;

import helpers.Node;

public class Intersection_2_7 {

    // O (n + m)
    public static int find(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> startPoint1 = list1;
        Node<Integer> startPoint2 = list2;

        Result res1 = getListLength(list1);
        Result res2 = getListLength(list2);
        if (res1.lastNode != res2.lastNode) {
            throw new RuntimeException("No list intersection found");
        }
        int diff = Math.abs(res1.length - res2.length);


        if (res1.length > res2.length) {
            startPoint1 = shiftPointer(startPoint1, diff);
        }
        if (res2.length > res1.length) {
            startPoint2 = shiftPointer(startPoint2, diff);
        }

        while (startPoint1.next != startPoint2.next) {
            startPoint1 = startPoint1.next;
            startPoint2 = startPoint2.next;
        }
        return startPoint1.next.data;
    }

    private static Node<Integer> shiftPointer(Node<Integer> list, int diff) {
        int i = 0;
        while (i < diff) {
            list = list.next;
            i++;

        }
        return list;
    }

    private static Result getListLength(Node<Integer> list1) {
        int result = 1;
        while (list1.next != null) {
            result++;
            list1 = list1.next;
        }
        return new Result(result, list1);
    }

    public static class Result {
        int length;
        Node<Integer> lastNode;

        public Result(int length, Node<Integer> lastNode) {
            this.length = length;
            this.lastNode = lastNode;
        }
    }

}
