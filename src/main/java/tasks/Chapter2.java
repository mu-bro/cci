package tasks;

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
        while(elem.next != null) {
            linkedListLength++;
            elem = elem.next;
        }
        if (linkedListLength-1 < n) {
            throw new Exception("Not enough elements in list");
        }
        int needToFind = linkedListLength - n;
        elem = head;

        if (needToFind == 0) {
            return elem.data;
        }
        for(int i = 1; i < needToFind; i++) {
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




    public static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
        }

        Node(Node<E> prev, E element, Node<E> next) {
            this.data = element;
            this.next = next;
            this.prev = prev;
        }

        public Node add(E data) {
            Node newElem = new Node(data);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = newElem;
            newElem.prev = n;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            Node n = this;
            while (n.next != null) {
                result.append(n.data);
                n = n.next;
            }
            result.append(n.data);
            return result.toString();
        }

    }
}
