package secondTime.tests;

import org.junit.Assert;
import org.junit.Test;
import secondTime.chapter5.BinaryToString;
import secondTime.chapter5.BitsToFlip;
import secondTime.chapter5.NextNumber;
import secondTime.chapter5.PairwiseSwap;

public class Chapter5_2 {

    @Test
    public void ZeroMatrixTest() {
        NextNumber.find(107);
    }

    @Test
    public void BinaryToStringTest() {
        Assert.assertEquals("0,11011", BinaryToString.convert(0.84375));
        Assert.assertEquals("ERROR", BinaryToString.convert(0.84374));
        Assert.assertEquals("0,11", BinaryToString.convert(0.75));
    }

    @Test
    public void BitsToFlipTest() {
        Assert.assertEquals(3, BitsToFlip.find(3,4));
        Assert.assertEquals(2, BitsToFlip.find(29,15));
    }

    @Test
    public void PairwiseSwapTest() {
        Assert.assertEquals(7, PairwiseSwap.swap(11));
        Assert.assertEquals(135, PairwiseSwap.swap(75));
    }
}
