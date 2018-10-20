package tasks.secondTime.Chapter2;

import helpers.Node;

import java.util.LinkedList;

public class RemoveDups_2_1 {

    public static String removeDup(Node<Integer> list) {
        Node<Integer> head = list;

        Node<Integer> currentElem = list;
        while (currentElem.next != null) {
            iterateElems(currentElem.next, currentElem.data);
            if (currentElem.next != null) {
                currentElem = currentElem.next;
            }
        }

        return head.toString();
    }

    private static void iterateElems(Node<Integer> list, Integer value) {
        while (list != null) {
            if (value == list.data) {
                removeElem(list);
            }
            list = list.next;
        }
    }

    private static void removeElem(Node<Integer> list) {
        if (list.next != null) {
            list.next.prev = list.prev;
        }
        if (list.prev != null) {
            list.prev.next = list.next;
        }
    }
}
