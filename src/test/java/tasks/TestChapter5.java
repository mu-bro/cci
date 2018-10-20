package tasks;

import org.junit.Assert;
import org.junit.Test;
import tasks.firstTime.Chapter5;

public class TestChapter5 {

    @Test
    public void setBitsBetweenTest() {
        Assert.assertEquals(-65, Chapter5.setBitsBetween(-73, 15, 2, 6));
    }

    @Test
    public void printBitsTest() {
        Assert.assertEquals("10100", Chapter5.printBits(20));
    }

    @Test
    public void findMaxBitsTest() {
        Assert.assertEquals(28, Chapter5.findMaxBits(26));
        Assert.assertEquals(129, Chapter5.findMaxBits(96));
    }

    @Test
    public void countBitsDifferenceTest() {
        Assert.assertEquals(2, Chapter5.countBitsDifference(31, 14));

    }
}
