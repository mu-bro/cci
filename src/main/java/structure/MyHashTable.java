package structure;

import java.util.LinkedList;

public class MyHashTable<K, V> {
    private int size = 0;
    private float LOAD_FACTOR = 0.75f;
    private LinkedList<Entry<K, V>>[] table = new LinkedList[2];

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        Entry<K, V> entry = new Entry(key, value);
        if (insertToList(table[index], entry)) size++;
        checkSize();
    }

    private void checkSize() {
        if (table.length * LOAD_FACTOR < size) {
            LinkedList<Entry<K, V>>[] oldTable = table;
            LinkedList<Entry<K, V>>[] toTable = new LinkedList[table.length * 2];
            table = toTable;

            LinkedList<Entry<K, V>> list;
            for (int i = 0; i < oldTable.length; i++) {
                list = oldTable[i];
                if (list != null) {
                    list.forEach(entry -> {
                        put(entry.key, entry.value);
                    });
                }
            }

        }
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        return getFromList(table[index], key);
    }

    private V getFromList(LinkedList<Entry<K, V>> list, K key) {
        if (list == null) return null;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key.equals(key)) {
                return list.get(i).value;
            }
        }
        return null;
    }

    private boolean insertToList(LinkedList<Entry<K, V>> list, Entry<K, V> entry) {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key.equals(entry.key)) {
                list.set(index, entry);
                return false;
            }
        }
        list.add(index, entry);
        return true;
    }


    private int getBucketIndex(K key) {
        int hash = key.hashCode();
        return (table.length - 1) & hash;
    }

    private class Entry<K, V> {
        public final K key;
        public final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
