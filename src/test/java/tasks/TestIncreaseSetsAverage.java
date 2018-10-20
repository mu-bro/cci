package tasks;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestIncreaseSetsAverage {

    @Test
    public void test() {
        boolean success = IncreaseSetsAverage.apply(
                new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
                new ArrayList<Integer>(Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19))
        );
        Assert.assertEquals(true, success);

    }

}
