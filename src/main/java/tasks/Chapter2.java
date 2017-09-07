package tasks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Chapter2 {

    public static <T> void removeDuplicates(Node<T> t) {
        Node<T> elem = t;
        Map<T,Boolean> map = new HashMap();
        while (elem.next != null) {
            if (map.containsKey(elem.item)) {
                elem.prev.next = elem.next;
            } else {
                map.put(elem.item, true);
            }
            elem = elem.next;
        }
    }

    public static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.item = data;
        }

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
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

        public String print() {
            StringBuilder result = new StringBuilder();
            Node n = this;
            while (n.next != null) {
                result.append(n.item);
                n = n.next;
            }
            return result.toString();
        }

    }
}
