package tasks.firstTime;

public class Chapter5 {

    public static int setBitsBetween(int input, int bits, int start, int finish) {
        int left = ~0 << finish;
        int right = (1 << start) - 1;
        int mask = left | right;
        input &= mask;
        input |= (bits << start);
        return input;
    }

    public static String printBits(int input) {
        StringBuilder result = new StringBuilder();
        while (input > 0) {
            int r = input % 2;
            input >>= 1;
            result.insert(0, r);
        }
        return result.toString();
    }

    public static int findMaxBits(int input) {
        int expectedCount = count1Bits(input);
        int actualCount = -1;
        while (expectedCount != actualCount) {
            actualCount = count1Bits(++input);
        }
        return input;
    }

    private static int count1Bits(int input) {
        int count = 0;
        int r;
        while (input > 0) {
            r = input % 2;
            if (r == 1) {
                count++;
            }
            input >>= 1;
        }
        return count;
    }

    public static int countBitsDifference(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c >>= 1) {
            count += c & 1;
        }
        return count;
    }

}


