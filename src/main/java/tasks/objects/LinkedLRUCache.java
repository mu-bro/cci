package tasks.objects;

import java.util.HashMap;
import java.util.Map;

public class LinkedLRUCache<K, V> {
    private class Node<K, V> {
        Node(Node prev, Node next, K key, V value) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.value = value;
        }
        public Node prev;
        public Node next;
        public K key;
        public V value;
    }

    public LinkedLRUCache(int maxSize) {
        cache = new HashMap<>();
        this.maxSize = maxSize;
        firstAdded = new Node(null, null, null, null);
        lastAdded = new Node(firstAdded, null, null, null);
        firstAdded.next = lastAdded;
    }

    private Map<K, Node<K,V>> cache;
    private Node lastAdded;
    private Node firstAdded;
    private int maxSize;

    public void put(K k, V v) {
        if (cache.containsKey(k)) {
            return;
        }


        Node<K, V> node = new Node<>(lastAdded, null, k, v);
        lastAdded.next = node;
        lastAdded = node;

        if (cache.isEmpty()) {
            firstAdded = node;
            firstAdded.prev = null;
            firstAdded.next = lastAdded;
        }
        if (cache.size() == maxSize) {
            Node secondAdded = firstAdded.next;
            cache.remove(firstAdded.key);
            firstAdded = secondAdded;
        }
        cache.put(k, node);
    }

    public V get(K k) {
        Node<K, V> currentNode = cache.get(k);
        if (currentNode == null) {
            return null;
        }
        if (currentNode == lastAdded) {
            return currentNode.value;
        }
        else if (currentNode == firstAdded) {
            Node secondAdded = firstAdded.next;
            firstAdded.prev = lastAdded;
            firstAdded.next = null;
            lastAdded.next = firstAdded;
            lastAdded = firstAdded;
            firstAdded = secondAdded;
        }
        else {
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
            lastAdded.next = currentNode;
            currentNode.prev = lastAdded;
            currentNode.next = null;
            lastAdded = currentNode;
        }
        return currentNode.value;
    }
}
