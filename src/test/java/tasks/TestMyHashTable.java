package tasks;

import org.junit.Assert;
import org.junit.Test;
import structure.MyHashTable;

public class TestMyHashTable {

    @Test
    public void hashMapIndexFor() {
        MyHashTable myHashTable = new MyHashTable();
        myHashTable.put("1", 1);
        myHashTable.put("2", 2);
        myHashTable.put("3", 3);
        myHashTable.put("4", 4);
        myHashTable.put("5", 5);
        myHashTable.put("6", 6);

        Assert.assertEquals(1, myHashTable.get("1"));
        Assert.assertEquals(2, myHashTable.get("2"));
        Assert.assertEquals(3, myHashTable.get("3"));
        Assert.assertEquals(4, myHashTable.get("4"));
        Assert.assertEquals(5, myHashTable.get("5"));
        Assert.assertEquals(6, myHashTable.get("6"));

        myHashTable.put("6", 8);
        myHashTable.put("6", 7);

        Assert.assertEquals(7, myHashTable.get("6"));
    }

}
