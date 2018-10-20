package tasks.secondTime.Chapter2;

import helpers.Node;

public class FindLoopStart {

    public static int find(Node<Integer> list) {
        Node<Integer> head = list;
        Node<Integer> fastPointer = list;
        Node<Integer> slowPointer = list;
        // fastPointer.next != null ||
        boolean first = true;
        while(fastPointer != slowPointer || first) {
            first = false;
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            System.out.println("P1 = " +fastPointer.data+ " P2 = " + slowPointer.data);
        }
        if (fastPointer.next == null) {
            throw new RuntimeException("No loop detected");
        }

        while (head != slowPointer) {
            head = head.next;
            slowPointer = slowPointer.next;
        }

        return head.data;
    }
}
