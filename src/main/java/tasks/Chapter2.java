package tasks;

import helpers.Node;

import java.util.HashMap;
import java.util.Map;

public class Chapter2 {

    public static <T> String removeDuplicates(Node<T> t) {
        Node<T> head = t;
        Node<T> elem = null;
        Map<T, Boolean> map = new HashMap();
        while (t != null) {
            if (map.containsKey(t.data)) {
                elem.next = t.next;
            } else {
                map.put(t.data, true);
                elem = t;
            }
            t = t.next;
        }
        return head.toString();
    }

    public static <T> String removeDuplicates3(Node<T> t) {
        Node<T> head = t;
        T currentData;
        Node<T> list;
        while (t.next != null) {
            list = t;
            currentData = list.data;
            while (list.next != null) {
                if (currentData.equals(list.next.data)) {
                    list.next = list.next.next;
                } else {
                    list = list.next;
                }
            }
            if (t.next != null) {
                t = t.next;
            }
        }
        return head.toString();
    }

    public static <T> T findNthElement(Node<T> head, int n) throws Exception {
        Node<T> elem = head;
        int linkedListLength = 1;
        while (elem.next != null) {
            linkedListLength++;
            elem = elem.next;
        }
        if (linkedListLength - 1 < n) {
            throw new Exception("Not enough elements in list");
        }
        int needToFind = linkedListLength - n;
        elem = head;

        if (needToFind == 0) {
            return elem.data;
        }
        for (int i = 1; i < needToFind; i++) {
            elem = elem.next;
        }
        return elem.next.data;
    }

    public static <T> T findNthElement2(Node<T> head, int n) throws Exception {
        if (n < 1) {
            throw new Exception("Not enough elements in list");
        }
        Node<T> p1 = head;
        Node<T> p2 = head;
        for (int i = 0; i < n - 1; i++) {
            if (p1 == null) {
                throw new Exception("Not enough elements in list");
            }
            p1 = p1.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2.data;
    }

    public static <T> void removeFromMiddle(Node<T> middle) {
        Node<T> nextElem = middle.next;
        middle.next = nextElem.next;
        middle.data = nextElem.data;
    }

    public static <T> Node findFirstInLoop(Node<T> head) throws Exception {
        Node<T> n1 = head;
        Node<T> n2 = head;
        while (n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1 == n2) {
                break;
            }
        }
        if (n2.next == null) {
            throw new Exception("no loop in linked list");
        }
        n1 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n2;
    }

}
