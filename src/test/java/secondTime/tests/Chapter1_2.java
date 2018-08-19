package secondTime.tests;

import org.junit.Assert;
import org.junit.Test;
import secondTime.chapter1.StringPermutationsHavePalindrome;
import secondTime.chapter1.ZeroMatrix;

import static secondTime.chapter1.OneWayStep.isOneWayStep;


public class Chapter1_2 {

    @Test
    public void isUniqueCharactersTest() {
        Assert.assertFalse(StringPermutationsHavePalindrome.isStringPermutationsHavePalindrome("qwe"));
        Assert.assertFalse(StringPermutationsHavePalindrome.isStringPermutationsHavePalindrome("abc"));
        Assert.assertFalse(StringPermutationsHavePalindrome.isStringPermutationsHavePalindrome("abcdefabc"));

        Assert.assertTrue(StringPermutationsHavePalindrome.isStringPermutationsHavePalindrome("adbcacb"));
        Assert.assertTrue(StringPermutationsHavePalindrome.isStringPermutationsHavePalindrome("qwerqwer"));
    }

    @Test
    public void isOneWayStepTest() {
        Assert.assertTrue(isOneWayStep("qwe","qse"));
        Assert.assertTrue(isOneWayStep("qwe","qwed"));
        Assert.assertTrue(isOneWayStep("bwes","qwes"));

        Assert.assertFalse(isOneWayStep("pale","bake"));
        Assert.assertFalse(isOneWayStep("pale","bales"));
        Assert.assertFalse(isOneWayStep("pale","paleen"));
    }

    @Test
    public void rowsAndColumnsToZeroTest() {
//        Chapter1.rowsAndColumnsToZero(createRandomMatrix(5,6));
        int[][] input = new int[][]{
                {30, 24, 18, 12, 0, 23},
                {31, 25, 19, 13, 7, 1},
                {32, 26, 20, 14, 8, 2},
                {33, 0, 21, 15, 9, 3},
                {34, 28, 22, 16, 10, 4},
                {35, 29, 23, 17, 11, 5}
        };
        int[][] expected = new int[][]{
                { 0, 0,  0,  0, 0, 0},
                {31, 0, 19, 13, 0, 1},
                {32, 0, 20, 14, 0, 2},
                { 0, 0,  0,  0, 0, 0},
                {34, 0, 22, 16, 0, 4},
                {35, 0, 23, 17, 0, 5}
        };
        Assert.assertArrayEquals(expected, ZeroMatrix.zero(input));
    }
}

