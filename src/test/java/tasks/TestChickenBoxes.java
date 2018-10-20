package tasks;

import org.junit.Assert;
import org.junit.Test;

public class TestChickenBoxes {

    @Test
    public void ChickenBoxesTest() {
        Assert.assertArrayEquals(new int[]{2, 0, 1}, ChickenBoxes.calculateBoxes(new Integer[]{15, 10, 5}, 34));
        Assert.assertArrayEquals(new int[]{2, 1, 0}, ChickenBoxes.calculateBoxes(new Integer[]{15, 10, 5}, 36));
        Assert.assertArrayEquals(new int[]{3, 0, 0}, ChickenBoxes.calculateBoxes(new Integer[]{15, 10, 5}, 44));
        Assert.assertArrayEquals(new int[]{2, 0, 1}, ChickenBoxes.calculateBoxes(new Integer[]{15, 10, 5}, 31));
        Assert.assertArrayEquals(new int[]{3, 0, 1}, ChickenBoxes.calculateBoxes(new Integer[]{15, 10, 6}, 46));
        Assert.assertArrayEquals(new int[]{0, 0, 1}, ChickenBoxes.calculateBoxes(new Integer[]{15, 10, 6}, 6));
        Assert.assertArrayEquals(new int[]{0, 1, 0}, ChickenBoxes.calculateBoxes(new Integer[]{15, 10, 6}, 7));
    }
}
