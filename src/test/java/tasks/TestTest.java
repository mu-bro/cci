package tasks;

import org.junit.Assert;
import org.junit.Test;
import tasks.objects.LinkedLRUCache;

public class TestTest {

    @Test
    public void hashMapIndexFor() {
        for(int i = 0; i <= 8; i++) {
            System.out.println(i + ") " + indexFor(i) + " (hash = " + hash(i) + ")");
        }
    }

    private int indexFor(int hash) {
        int n = 8;
        return (n - 1) & hash;
    }

    static int hash(Integer key) {
//        h ^= (h >>> 20) ^ (h >>> 12);
//        return h ^ (h >>> 7) ^ (h >>> 4);
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
