package tasks;

import org.junit.Assert;
import org.junit.Test;


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
        Assert.assertTrue(Chapter1.isStringsAnagrams("aaabc","cbaaa"));
        Assert.assertTrue(Chapter1.isStringsAnagrams("aaaabbbb","abababab"));
        Assert.assertTrue(Chapter1.isStringsAnagrams("qwertyyu","uytrewyq"));
        Assert.assertFalse(Chapter1.isStringsAnagrams("abbc","aacb"));
        Assert.assertFalse(Chapter1.isStringsAnagrams("aaabbbb","aaabbb"));
        Assert.assertFalse(Chapter1.isStringsAnagrams("qwertyu","ytrewq"));
    }

    @Test
    public void replaceSpacesTest() {
        Assert.assertTrue("aaa%20bc%20".equals(new String(Chapter1.replaceSpaces("aaa bc AAAAAAAAAAAAAA".toCharArray(), 8))));
        Assert.assertTrue("a%20%2011aa%20bc%20".equals(new String(Chapter1.replaceSpaces("a  11aa bc AAAAAAAAAAAAAA".toCharArray(), 12))));
        Assert.assertTrue("%20%20".equals(new String(Chapter1.replaceSpaces("  AAAAAAAAAAAAAA".toCharArray(), 3))));
    }

}
