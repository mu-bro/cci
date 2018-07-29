package secondTime.tests;

import org.junit.Assert;
import org.junit.Test;
import secondTime.chapter1.StringPermutationsHavePalindrome;

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
}

