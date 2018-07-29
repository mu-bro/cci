package secondTime.tests;

import org.junit.Assert;
import org.junit.Test;
import secondTime.chapter1.StringPermutationsHavePalindrome;


public class Chapter1_2 {

    @Test
    public void isUniqueCharactersTest() {
        Assert.assertFalse(StringPermutationsHavePalindrome.isStringPermutationsHavePalindrome("qwe"));
        Assert.assertFalse(StringPermutationsHavePalindrome.isStringPermutationsHavePalindrome("abc"));
        Assert.assertFalse(StringPermutationsHavePalindrome.isStringPermutationsHavePalindrome("abcdefabc"));

        Assert.assertTrue(StringPermutationsHavePalindrome.isStringPermutationsHavePalindrome("adbcacb"));
        Assert.assertTrue(StringPermutationsHavePalindrome.isStringPermutationsHavePalindrome("qwerqwer"));
    }


}
