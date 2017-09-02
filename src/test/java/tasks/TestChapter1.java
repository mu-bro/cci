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
        Assert.assertTrue("abcd".equals(Chapter1.removeDuplicatedCharacters("abcd")));
    }

}
