package firstTime.tasks;

import org.junit.Assert;
import org.junit.Test;

import static firstTime.helpers.Helper.createMatrix;


public class TestChapter1 {

    @Test
    public void isUniqueCharactersTest() {
        Assert.assertTrue(Chapter1.isUniqueCharacters("abcd"));
        Assert.assertFalse(Chapter1.isUniqueCharacters("abcda"));
        Assert.assertTrue(Chapter1.isUniqueCharacters("abcxvn"));
        Assert.assertTrue(Chapter1.isUniqueCharacters(""));

    }

    @Test
    public void reverseStringTest() {
        Assert.assertTrue("dcba".equals(Chapter1.reverseString("abcd")));
        Assert.assertTrue("cba".equals(Chapter1.reverseString("abc")));
        Assert.assertTrue("".equals(Chapter1.reverseString("")));
    }

    @Test
    public void removeDuplicatedCharactersTest() {
        Assert.assertTrue("abc".equals(Chapter1.removeDuplicatedCharacters("abca")));
        Assert.assertTrue("abcd".equals(Chapter1.removeDuplicatedCharacters("abacd")));
        Assert.assertTrue("abcd".equals(Chapter1.removeDuplicatedCharacters("abaaacd")));
        Assert.assertTrue("ab".equals(Chapter1.removeDuplicatedCharacters("aaaabbbbb")));
        Assert.assertTrue("abcd".equals(Chapter1.removeDuplicatedCharacters("abd")));
    }

    @Test
    public void isStringsAnagramsTest() {
        Assert.assertTrue(Chapter1.isStringsAnagrams("aaabc", "cbaaa"));
        Assert.assertTrue(Chapter1.isStringsAnagrams("aaaabbbb", "abababab"));
        Assert.assertTrue(Chapter1.isStringsAnagrams("qwertyyu", "uytrewyq"));
        Assert.assertFalse(Chapter1.isStringsAnagrams("abbc", "aacb"));
        Assert.assertFalse(Chapter1.isStringsAnagrams("aaabbbb", "aaabbb"));
        Assert.assertFalse(Chapter1.isStringsAnagrams("qwertyu", "ytrewq"));
    }

    @Test
    public void replaceSpacesTest() {
        Assert.assertTrue("aaa%20bc%20".equals(new String(Chapter1.replaceSpaces("aaa bc AAAAAAAAAAAAAA".toCharArray(), 8))));
        Assert.assertTrue("a%20%2011aa%20bc%20".equals(new String(Chapter1.replaceSpaces("a  11aa bc AAAAAAAAAAAAAA".toCharArray(), 12))));
        Assert.assertTrue("%20%20".equals(new String(Chapter1.replaceSpaces("  AAAAAAAAAAAAAA".toCharArray(), 3))));
    }


    @Test
    public void rotateImageTest() {
        int[][] expected_4 = new int[][]{
                {12, 8, 4, 0},
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3}
        };
        int[][] expected_6 = new int[][]{
                {30, 24, 18, 12, 6, 0},
                {31, 25, 19, 13, 7, 1},
                {32, 26, 20, 14, 8, 2},
                {33, 27, 21, 15, 9, 3},
                {34, 28, 22, 16, 10, 4},
                {35, 29, 23, 17, 11, 5}
        };
        Assert.assertArrayEquals(expected_4, Chapter1.rotateImage(createMatrix(4), 4));
        Assert.assertArrayEquals(expected_6, Chapter1.rotateImage(createMatrix(6), 6));
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
        Assert.assertArrayEquals(expected, Chapter1.rowsAndColumnsToZero(input));
    }

    @Test
    public void isRotationTest() {
        Assert.assertTrue(Chapter1.isRotation("asdfg","dfgas"));
        Assert.assertTrue(Chapter1.isRotation("helloworld","worldhello"));
        Assert.assertTrue(Chapter1.isRotation("apple","leapp"));
        Assert.assertFalse(Chapter1.isRotation("applee","apple"));
        Assert.assertFalse(Chapter1.isRotation("asdfg","gfdsa"));
        Assert.assertFalse(Chapter1.isRotation("helloworld","hellaworld"));
    }

}
