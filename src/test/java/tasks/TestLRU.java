package tasks;

import org.junit.Assert;
import org.junit.Test;
import tasks.objects.LinkedLRUCache;

public class TestLRU {

    @Test
    public void LinkedLRUCacheTest() {
        LinkedLRUCache<Integer, String> cache = new LinkedLRUCache<Integer, String>(3);
        cache.put(1, "A");
        Assert.assertEquals("A", cache.get(1));
        cache.put(2, "B");
        cache.put(3, "C");
        cache.put(4, "D");
        Assert.assertNull(cache.get(1));
        Assert.assertEquals("B", cache.get(2));
        cache.put(5, "E");
        Assert.assertNull(cache.get(3));
    }
}
