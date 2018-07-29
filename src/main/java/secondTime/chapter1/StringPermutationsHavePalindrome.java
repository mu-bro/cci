package secondTime.chapter1;

public class StringPermutationsHavePalindrome {

    public static boolean isStringPermutationsHavePalindrome(String input) {
        long bitMask = 0;
        for (char letter : input.toCharArray()) {
            int num = 1 << ((int) letter - 'a');
            if ((bitMask & num) > 0) {
                bitMask &= ~num;
            } else {
                bitMask |= num;
            }
        }
        if (bitMask == 0) return true;

        return isPowerOf2(bitMask);
    }

    private static boolean isPowerOf2(long number) {
        double power = log(number, 2);
        return (((power*10) % 10) == 0) ? true : false;
    }


    static double log(long x, int base)
    {
        return (Math.log(x) / Math.log(base));
    }
}
